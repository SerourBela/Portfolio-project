<?php $__env->startSection('title','| قائمة اطفال حصة معالجة'); ?>
<?php $__env->startSection('content'); ?>
    <br>

    <br>

    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">

            <div class="panel-body">


                <?php if($message = Session::get('success')): ?>
                    <div class="alert alert-success">
                        <p><?php echo e($message); ?></p>
                    </div>
                <?php endif; ?>
                <table class="table table-bordered table-striped">
                    <tr>
                        <th width="6%">الرقم</th>
                        <th width="10%">الصورة </th>
                        <th  width = "30px">اللقب</th>
                        <th  width = "30px">الاسم</th>
                        <th  width = "30px">الجنس</th>



                    </tr>
                    <?php if(count($enfants)): ?>
                        <?php $__currentLoopData = $enfants; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $c): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>

                            <tr  data-href="<?php echo e(route('pagecarsspecialiste.affiche',$c->id_enfant)); ?>" style="cursor: pointer;">
                                <td><?php echo e($c->id_enfant); ?></td>
                                <td value="<?php echo e($c->id_enfant); ?>"><img src="<?php echo e(asset('storage/enfants/'.$c->image)); ?>"  style="border-radius: 8px; display: block;
                                     margin-left: auto;
                                     margin-right: auto;  border: 2px solid #ddd;
                                     " width="50"  />
                                <td value="<?php echo e($c->id_enfant); ?>"><?php echo e($c->prenom); ?> </td>
                                <td value="<?php echo e($c->id_enfant); ?>">  <?php echo e($c->nom); ?></td>

                                <td><?php echo e($c->sexe); ?></td>



                            </tr>

                        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>

                    <?php else: ?>
                        <tr><td colspan="7">لا يوجد طفل</td></tr>
                    <?php endif; ?>
                </table>
                <?php echo e($enfants->render()); ?>

            </div>
        </div>               </section>
    <script>
        document.addEventListener("DOMContentLoaded",()=>{
            const rows=document.querySelectorAll("tr[data-href]");
            rows.forEach(row=>{
                row.addEventListener("click",()=>{
                    window.location.href=row.dataset.href;
                });

            });
        });

        /* $(document).ready(function () {
             $(document.body).on("click","tr[data-href]",function () {
                 window.location.href=this.dataset.href;

             });

         });*/
    </script>
    <script type="text/javascript">
        $("tr").not(':first').hover(
            function () {
                $(this).css("background","#fef5d5");
            },
            function () {
                $(this).css("background","");
            }

        );

    </script>
    <script type="text/javascript">
        function passvalues(){
            var idenf=document.getElementById("idEnfant").value;
            localStorage.setItem("idenfvalue",idenf);
            return false;
        }
    </script>
    <script type="text/javascript">
        $('#search').on('keyup',function(){
            $value=$(this).val();
            $.ajax({
                type : 'get',
                url :  '<?php echo e(URL::to('/pagecarsspecialiste/diagnostics/search')); ?>',
                data:{'search':$value},
                success:function(data){
                    $('tbody').html(data);
                }
            });
        })
    </script>



<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.specialistes', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/pagecarsspecialiste/diagnostics/index.blade.php ENDPATH**/ ?>