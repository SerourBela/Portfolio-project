<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>   تشخيص <?php echo $__env->yieldContent('title'); ?></title>


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
    <script src="<?php echo e(asset('https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js')); ?>"></script>
    <link href="<?php echo e(asset('https://fonts.googleapis.com/css2?family=Tajawal&display=swap')); ?>" rel="stylesheet">

    <link rel="stylesheet" href="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css')); ?>">
    <script src="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js')); ?>"></script>

    <!-- CLICKABLE -->
    <script src="<?php echo e(asset('https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js')); ?>"></script>
    <script src="<?php echo e(asset('https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js')); ?>"></script>

    <!-- affiche search-->



    <!-- affiche kan-->

    <!-- khaoula jequery -->

    <!-- khaoula jequery -->

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
                    <div class="image" id="image">
                        <?php if(\Illuminate\Support\Facades\Auth::user()->image): ?>
                            <img src="<?php echo e(asset('storage/specialistes/'.\Illuminate\Support\Facades\Auth::user()->image)); ?>"  alt="Avatar" style="width:50px;height: 50px;border-radius: 50%;"/>
                        <?php else: ?>
                                <img src="<?php echo e(asset('dist/img/admin.png')); ?>">
                            <?php endif; ?>
                    </div>

                    <div class="info">
                        <a href="#" class="d-block"><?php echo e(\Illuminate\Support\Facades\Auth::user()->name); ?></a>
                        <a href="#"><i class="fa fa-circle text-success"></i>متصل</a>
                    </div>
                </div>

                <!-- Sidebar Menu -->
                <nav class="mt-2">
                    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                        <!-- Add icons to the links using the .nav-icon class
                             with font-awesome or any other icon font library -->
                        <?php
                        $segment=Request::segment(2);

                        ?>
                        <li class="nav-item has-treeview menu-open">
                            <a href="<?php echo e(route('pagecarsspecialiste')); ?>" class="nav-link <?php if(!$segment ): ?>active <?php endif; ?>">
                                <i class="nav-icon fa fa-user-plus"></i>
                                <p>
                                    تشخيص
                                </p>
                            </a>

                        </li>


                        <li class="nav-item has-treeview">
                            <a href="<?php echo e(route('pagecarsspecialiste.diagnostics.index')); ?>" class="nav-link <?php if($segment=='diagnostics'): ?> active <?php endif; ?>">
                                <i class="nav-icon fa fa-table"></i>
                                <p>
                                     قائمة الاطفال
                                </p>
                            </a>
                        </li>



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



                    </ul>
                </nav>
                <!-- /.sidebar-menu -->
            </div>
        </div>
        <!-- /.sidebar -->
    </aside>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <?php echo $__env->make('partials._messages', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
        <?php echo $__env->yieldContent('content'); ?>

        <?php echo $__env->make('partials._footer', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
    </div>
</div>
</body>
<script src="<?php echo e(asset('https://code.jquery.com/ui/1.12.1/jquery-ui.min.js')); ?>"></script>
<!-- AdminLTE App -->
<script src="<?php echo e(asset('dist/js/adminlte.js')); ?>"></script>

<script src="<?php echo e(asset('plugins/jquery/jquery.min.js')); ?>"></script>
<!-- jQuery UI 1.11.4 -->

</html>
<?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/layouts/specialistes.blade.php ENDPATH**/ ?>