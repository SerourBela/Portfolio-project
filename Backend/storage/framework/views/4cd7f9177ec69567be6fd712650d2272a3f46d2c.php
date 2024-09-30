<?php $__env->startSection('title','  |المعالجين'); ?>
<?php $__env->startSection('content'); ?>
<br>
<br>
    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">

            <p>

                <a href="<?php echo e(route('addtraitant')); ?>" class="btn btn-primary">اضافة فرد جديد</a>

            </p>

        <?php if($message = Session::get('success')): ?>
                <div class="alert alert-success">
                    <p><?php echo e($message); ?></p>
                </div>
            <?php endif; ?>
            <table class="table table-bordered table-striped">
                <tr>
                    <th width="10%">الصورة الشمسية</th>
                    <th width = "35px"> اللقب</th>
                    <th  width = "35px">الاسم</th>
                    <th  width = "35px">البريد الالكتروني</th>
                    <th width = "30px">الحركة</th>
                </tr>
                <?php if(count($traitants)): ?>
                <?php $__currentLoopData = $traitants; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $c): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                    <tr>
                        <td><img src="<?php echo e(asset('storage/traitants/'.$c->image)); ?>" class="img-thumbnail"  width="50"  />
                        <td><?php echo e($c->prenom); ?></td>
                        <td><?php echo e($c->nom); ?></td>
                        <td><?php echo e($c->email); ?></td>
                        <td>
                                <a href="<?php echo e(route('admin.traitants.show',$c->id_traitant)); ?>" class="btn  btn-success">عرض</a>
                                <a href="<?php echo e(route('admin.traitants.edit',$c->id_traitant)); ?>" class="btn btn-info">تعديل</a>
                                <button class="btn btn-danger" data-catid="<?php echo e($c->id_traitant); ?>" data-toggle="modal" data-target="#delete">مسح</button>
                        </td>
                    </tr>
                <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                <?php else: ?>
                    <tr><td colspan="5">لا يوجد معالج</td></tr>
                <?php endif; ?>
            </table>
            <?php echo e($traitants->render()); ?>

        </div>
    </section>
<div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <form action="<?php echo e(route('admin.traitants.destroy','test')); ?>" method="post">
                <?php echo e(method_field('delete')); ?>

                <?php echo e(csrf_field()); ?>

                <div class="modal-body">
                    <p class="text-center">
                        هل انت متأكد من الحذف؟
                    </p>
                    <input type="hidden" name="id_traitant" id="cat_id" value="">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-dismiss="modal">لا, الغاء</button>
                    <button type="submit" class="btn btn-warning">نعم, حذف</button>
                </div>
            </form>
        </div>
    </div>
</div>

<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.admin', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/admin/traitants/index.blade.php ENDPATH**/ ?>