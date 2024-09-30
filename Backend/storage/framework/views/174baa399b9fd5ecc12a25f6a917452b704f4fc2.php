<?php $__env->startSection('title','| حصة معالجة'); ?>

<?php $__env->startSection('content'); ?>
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">

            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="card card-primary">
                    <div class="card-header">
                        <h3 class="card-title">المعلومات</h3>
                    </div>


                    <form method="post" action="<?php echo e(route('pagetraitant.seancetraitements.store')); ?>" enctype="multipart/form-data">
                        <input type="hidden" name="_token" value="<?php echo e(csrf_token()); ?>">
                        <!-- /.card-header -->
                        <?php if($message = Session::get('success')): ?>
                            <div class="alert alert-danger" role="alert">
                                <p><?php echo e($message); ?></p>
                            </div>
                        <?php endif; ?>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">


                                    <div class="form-group">
                                        <label>الاسم الكامل :</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-user"></i></span>
                                            </div>

                                            <select   class="form-control" style="width: 461px" id="named" name="enfant_id" >
                                                <option ></option>
                                                <?php $__currentLoopData = $enfants; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $enfant): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                                    <option  value="<?php echo e($enfant->id_enfant); ?>"><?php echo e($enfant->prenom); ?> <?php echo e($enfant->nom); ?></option>
                                                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                                            </select>


                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>تاريخ الحصة :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-calendar"></i></span>


                                            </div>
                                            <input type="date" class="form-control" name="dateTraite" readonly value="<?php echo e($dateActuelle); ?>" data-inputmask="'alias': 'yyyy/mm/dd'" data-mask>

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label> الطريقة المستعملة:</label>
                                        <select class="form-control" name="methode">
                                            <option methode="TEACCH"> TEACCH</option>
                                            <option methode="ABA"> ABA</option>
                                            <option methode="PECS"> PECS</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>
                                            التعليق :
                                        </label>
                                        <textarea class="remarquearea" rows="3,5" cols="58,5" name="commentaire" placeholder="لا يوجد"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label>
                                            نصائح للوالدين :
                                        </label>
                                        <textarea class="remarquearea" rows="3,5" cols="58,5" name="conseils" placeholder="لا توجد"></textarea>
                                    </div>
                                </div>
                                <!-- /.col -->
                                <div class="col-md-6">

                                    <div class="form-group">

                                        <label> مدة الحصة :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-clock-o"></i></span>

                                            </div>
                                            <input type="text" class="form-control" name="duree">

                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label> التقييم :</label>

                                        <div class="input-group">
                                            <select class="form-control" name="note">
                                                <option note="1">1</option>
                                                <option note="2">2</option>
                                                <option note="3">3</option>
                                                <option note="4">4</option>
                                                <option note="5">5</option>
                                                <option note="6">6</option>
                                                <option note="7">7</option>
                                                <option note="8">8</option>
                                                <option note="9">9</option>
                                                <option note="1O">10</option>
                                            </select>

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>
                                            الوصف :
                                        </label>
                                        <textarea class="remarquearea" rows="13" cols="58" name="description" placeholder="لا يوجد"></textarea>
                                    </div>

                                </div>
                                <!-- /.col (right) -->

                            </div>
                            <!-- /.row -->

                        </div><!-- /.container-fluid -->
                        <div class="card ">
                            <button type="submit" class="btn btn-primary" >حفظ</button>
                        </div>
                    </form></div>


                <!-- ./wrapper -->
            </div>
        </section>
    </div>
    <script src="<?php echo e(asset('//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js')); ?>"></script>
    <script type="text/javascript">

        $("#nameid").select2({
            placeholder: "اختر ",
            allowClear: true
        });
    </script>
    <script type="text/javascript">

        $("#named").select2({
            placeholder: "اختر ",
            allowClear: true
        });
    </script>

    <!-- jQuery -->

<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.traitants', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/pagetraitant/seancetraitements/create.blade.php ENDPATH**/ ?>