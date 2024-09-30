<?php $__env->startSection('title','  |المشخصين '); ?>
<?php $__env->startSection('content'); ?>
    <br>
    <br>

    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">
            <p>
                <a href="<?php echo e(route('addspecialiste')); ?>" class="btn btn-primary">اضافة فرد جديد</a>
            </p>

            <?php if($message = Session::get('success')): ?>
                <div class="alert alert-success">
                    <button type="button" class="close"
                            data-dismiss="alert" aria-hidden="true">&times;
                    </button>
                    <p><?php echo e($message); ?></p>
                </div>
            <?php endif; ?>
            <table class="table table-bordered table-striped">
                <tr>
                    <th width="5%">الرقم</th>
                    <th width="10%">الصورة الشمسية</th>
                    <th width = "15%"> اللقب</th>
                    <th  width = "15%">الاسم</th>
                    <th  width = "20%">البريد الالكتروني</th>
                    <th  width = "10%">رقم الهاتف</th>
                    <th width = "30px">الحركة</th>
                </tr>
                <?php if(count($carsspecialistes)): ?>
                    <?php $__currentLoopData = $carsspecialistes; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $c): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <tr>
                            <td><?php echo e($c->id_carsspecialiste); ?></td>
                            <td><img src="<?php echo e(asset('storage/specialistes/'.$c->image)); ?>"  style="border-radius: 8px; display: block;
                                     margin-left: auto;
                                     margin-right: auto;  border: 2px solid #ddd;
                                     " width="50"  />

                            <td><?php echo e($c->nom); ?></td>
                            <td><?php echo e($c->prenom); ?></td>
                            <td><?php echo e($c->email); ?></td>
                            <td><?php echo e($c->numTel); ?></td>
                            <td>


                                    <a href="<?php echo e(route('admin.carsSpecialistes.show',$c->id_carsspecialiste)); ?>" class="btn  btn-success">عرض</a>

                                    <a href="<?php echo e(route('admin.carsSpecialistes.edit',$c->id_carsspecialiste)); ?>" class="btn btn-info">تعديل</a>

                                    <button class="btn btn-danger" data-catid="<?php echo e($c->id_carsspecialiste); ?>" data-toggle="modal" data-target="#delete">مسح</button>
                            </td>
                        </tr>
                    <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                <?php else: ?>
                    <tr><td colspan="7">لا يوجد مشخص</td></tr>
                <?php endif; ?>
            </table>
        </div>
        <div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                        <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                    </div>
                    <form action="<?php echo e(route('admin.carsSpecialistes.destroy','test')); ?>" method="post">
                        <?php echo e(method_field('delete')); ?>

                        <?php echo e(csrf_field()); ?>

                        <div class="modal-body">
                            <p class="text-center">
                                هل انت متأكد من الحذف؟
                            </p>
                            <input type="hidden" name="id_carsspecialiste" id="cat_id" value="">

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">لا, الغاء</button>
                            <button type="submit" class="btn btn-warning">نعم, حذف</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </section>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.admin', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/admin/carsSpecialistes/index.blade.php ENDPATH**/ ?>