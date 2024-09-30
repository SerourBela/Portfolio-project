<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>موقع التوحد <?php echo $__env->yieldContent('title'); ?> </title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<?php echo e(asset('plugins/font-awesome/css/font-awesome.min.css')); ?>">
    <!-- Ionicons -->
    <!-- Theme style -->
    <link rel="stylesheet" href="<?php echo e(asset('dist/css/adminlte.min.css')); ?>">
    <link rel="stylesheet" href="<?php echo e(asset('dist/css/bootstrap-rtl.min.css')); ?>">
    <!-- template rtl version -->
    <link rel="stylesheet" href="<?php echo e(asset('dist/css/custom-style.css')); ?>">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="<?php echo e(asset('https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css')); ?>">


    <!-- CLICKABLE -->
    <script src="<?php echo e(asset('https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js')); ?>"></script>

    <link rel="stylesheet" href="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css')); ?>">
    <!-- CLICKABLE -->


    <!-- confirm delete!-->




</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

    <!-- Navbar -->
<?php echo $__env->make('partials._nav', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
<!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">


        <!-- Sidebar -->
        <div class="sidebar" style="direction: ltr">
            <div style="direction: rtl">
                <!-- Sidebar user panel (optional) -->
                <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                    <div class="image">
                        <img src="<?php echo e(asset('dist/img/admin.png')); ?>" alt="Avatar" style="width:70px;height: 50px">
                    </div>
                    <div class="info">
                        <a href="#" class="d-block"><?php echo e(\Illuminate\Support\Facades\Auth::user()->name); ?></a>
                        <a href="#"><i class="fa fa-circle text-success"></i>متصل </a>

                    </div>
                </div>

                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                        <!-- Add icons to the links using the .nav-icon class
                             with font-awesome or any other icon font library -->

                        <?php
                        $segment=Request::segment(2);
                        //echo $segment;

                        ?>

                        <li class="nav-item has-treeview menu-open">
                            <a href="(<?php echo e(route('home')); ?>||<?php echo e(route('addspecialiste')); ?>|| <?php echo e(route('addtraitant')); ?>) "  data-toggle="dropdown" class="nav-link <?php if(!$segment ): ?>active <?php else: ?> <?php if($segment=='interfaceaddspecialiste' ): ?>active <?php else: ?> <?php if($segment=='interfaceaddtraitant' ): ?>active <?php endif; ?> <?php endif; ?>  <?php endif; ?> ">
                                <i class="nav-icon fa fa-user-plus"></i>
                                <p>
                                    التسجيلات
                                    <i class="right fa fa-angle-left"></i>
                                </p>
                            </a>
                            <ul class="nav nav-treeview">
                                <li class="nav-item">
                                    <a href="<?php echo e(route('addspecialiste')); ?>" class="nav-link <?php if($segment=='interfaceaddspecialiste' ): ?>active <?php endif; ?>">
                                        <i class="fa fa-user-md nav-icon"></i>
                                        <p>المشخصين</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="<?php echo e(route('addtraitant')); ?>" class="nav-link <?php if($segment=='interfaceaddtraitant' ): ?>active <?php endif; ?>">
                                        <i class="fa fa-user nav-icon"></i>
                                        <p>المعالجين</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="<?php echo e(route('home')); ?>"  class="nav-link <?php if(!$segment ): ?>active <?php endif; ?>">
                                        <i class="fa fa-child nav-icon"></i>
                                        <p>الأطفال</p>
                                    </a>
                                </li>
                            </ul>

                        </li >

                        <li class="nav-item has-treeview menu-open">
                            <a href=" "  class="nav-link <?php if($segment=='specialistes' ): ?>active <?php else: ?> <?php if($segment=='traitants' ): ?>active <?php else: ?> <?php if($segment=='enfants' ): ?>active <?php endif; ?> <?php endif; ?>  <?php endif; ?> ">
                                <i class="nav-icon fa fa-table"></i>
                                <p>
                                    قائمة المسجلين
                                    <i class="fa fa-angle-left right"></i>
                                </p>
                            </a>
                            <ul class="nav nav-treeview  ">
                                <li class="nav-item">
                                    <a href="<?php echo e(route('admin.carsSpecialistes.index')); ?>"  class="nav-link
                                       <?php if($segment=='carsSpecialistes'): ?>
                                        active <?php endif; ?>">
                                        <i class="fa fa-user-md nav-icon"></i>
                                        <p>المشخصين</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="<?php echo e(route('admin.traitants.index')); ?>" class="nav-link
                                       <?php if($segment=='traitants'): ?>
                                        active
<?php endif; ?>
                                        ">
                                        <i class="fa fa-user nav-icon"></i>
                                        <p>المعالجين</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="<?php echo e(route('admin.enfants.index')); ?>" class="nav-link <?php if($segment=='enfants'): ?>
                                        active
<?php endif; ?>">
                                        <i class="fa fa-child nav-icon"></i>
                                        <p>الأطفال</p>
                                    </a>
                                </li>
                            </ul>

                        <li class="nav-item">
                            <a href="<?php echo e(route('chart.index')); ?>" class="nav-link <?php if($segment=='chart' ): ?>active <?php endif; ?>">
                                <i class="nav-icon fa fa-pie-chart"></i>
                                <p>
                                    احصائيات
                                </p>
                            </a>

                        <li class="nav-item">
                            <a href="<?php echo e(route('admin.applications.index')); ?>"  class="nav-link  <?php if($segment=='applications'): ?> active <?php endif; ?>" >
                                <i class="fa fa-caret-square-o-right"></i>
                                <p>
                                    التطبيقات
                                </p>
                            </a>
                        </li>
                        <li class="nav-item">


                            <a href="<?php echo e(route('logout')); ?>" id="lien" class="nav-link <?php if($segment=='logout'): ?> active <?php endif; ?>" onclick="event.preventDefault();
                                                     document.getElementById('logout-form').submit();">
                                <i class="nav-icon fa fa-sign-out"></i>
                                <p>
                                    تسجيل الخروج
                                </p>
                            </a>
                            <form id="logout-form" action="<?php echo e(route('logout')); ?>" method="POST" style="display: none;">
                                <?php echo csrf_field(); ?>
                            </form>
                        </li>

                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <?php echo $__env->make('partials._messages', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
        <?php echo $__env->yieldContent('content'); ?>

        <?php echo $__env->make('partials._footer', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
    </div>
</div>
<script src="<?php echo e(asset('js/app.js')); ?>"></script>
<script>

    $('#edit').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var titre = button.data('mytitle')
        var description = button.data('mydescription')
        var cat_id=button.data('catid')
        var modal = $(this)
        modal.find('.modal-body #titre').val(titre);
        modal.find('.modal-body #des').val(description);
        modal.find('.modal-body #cat_id').val(cat_id);
    })
    $('#delete').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var cat_id = button.data('catid')
        var modal = $(this)
        modal.find('.modal-body #cat_id').val(cat_id);
    })
</script>
</body>
<script src="<?php echo e(asset('plugins/jquery/jquery.min.js')); ?>"></script>

<!-- jQuery UI 1.11.4 -->
<script src="<?php echo e(asset('https://code.jquery.com/ui/1.12.1/jquery-ui.min.js')); ?>"></script>
<!-- AdminLTE App -->
<script src="<?php echo e(asset('dist/js/adminlte.js')); ?>"></script>
</html>



<?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/layouts/admin.blade.php ENDPATH**/ ?>