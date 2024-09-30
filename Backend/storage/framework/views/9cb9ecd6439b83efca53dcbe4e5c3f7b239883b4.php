<?php if($errors->any()): ?>
    <div class="alert alert-danger">
        يوجد بعض الاخطاء<br><br>
        <ul>
            <?php $__currentLoopData = $errors->all(); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $error): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                <li><?php echo e($error); ?></li>
            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
        </ul>
    </div>
<?php endif; ?>
<?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/partials/_messages.blade.php ENDPATH**/ ?>