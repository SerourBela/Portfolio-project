@extends('layouts.autism')
@section('content')
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">اضافة طفل</h1>
                </div><!-- /.col -->

            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-6">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">بيانات الطفل</h3>
                            </div>
                            <form role="form">
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <div class="form-group">
                                        <label>اللقب :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-child "></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>الإسم :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-child "></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label> الجنس :</label>
                                        <select class="form-control">
                                            <option> ذكر</option>
                                            <option> أنثى</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>  تاریخ الميلاد :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                                            </div>
                                            <input type="text" class="form-control ltr" data-inputmask="'alias': 'yyyy/mm/dd'" data-mask>
                                        </div>
                                        <!-- /.input group -->
                                    </div>
                                    <div class="form-group">
                                        <label>مكان الميلاد :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                    <span class="input-group-text"><i class="fa fa-map-marker"></i>
                                                    </span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label> زمرة الدم :</label>
                                        <select class="form-control">
                                            <option> +A</option>
                                            <option> -A</option>
                                            <option> +B</option>
                                            <option> +B</option>
                                            <option> +AB</option>
                                            <option> -AB</option>
                                            <option> +O</option>
                                            <option> -O</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>الولاية  :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>البلدية  :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>العنوان  :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>
                                    </div>
                                </div>



                            </form>
                        </div>
                        <!-- /.col (right) -->

                    </div>
                    <!-- /.row -->
                    <div class="col-md-6">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">بيانات الأولياء</h3>
                            </div>
                            <form role="form">
                                <!-- /.card-header -->
                                <div class="card-body">

                                    <div class="form-group">

                                        <label>إسم الأب :</label>

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="fa fa-user"></i></span>


                                            </div>
                                            <input type="text" class="form-control">

                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">

                                            <div class="form-group">
                                                <label>المستوى الدراسي :</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-graduation-cap"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <label>رقم الهاتف :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label>البريد الإلكتروني :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>إسم الأم :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <label>المستوى الدراسي :</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-graduation-cap"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>

                                            <div class="form-group">

                                                <label>رقم الهاتف :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-phone"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>البريد الإلكتروني :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-envelope"></i></span>


                                                    </div>
                                                    <input type="text" class="form-control">

                                                </div>
                                            </div>


                                        </div>
                                        <div class="col-md-6">

                                            <div class="form-group">
                                                <label>  تاریخ الميلاد :</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                                                    </div>
                                                    <input type="text" class="form-control ltr" data-inputmask="'alias': 'yyyy/mm/dd'" data-mask>
                                                </div>
                                                <!-- /.input group -->
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group">
                                                    <label>عنوان العمل :</label>

                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                                        </div>
                                                        <input type="text" class="form-control">

                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <label> كلمة المرور :</label>

                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="fa fa-lock"></i></span>


                                                        </div>
                                                        <input type="text" class="form-control">

                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label>اللقب :</label>

                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="fa fa-user"></i></span>


                                                        </div>
                                                        <input type="text" class="form-control">

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label>  تاریخ الميلاد :</label>

                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                                                        </div>
                                                        <input type="text" class="form-control ltr" data-inputmask="'alias': 'yyyy/mm/dd'" data-mask>
                                                    </div>
                                                    <!-- /.input group -->
                                                </div>
                                                <div class="form-group">
                                                    <div class="form-group">
                                                        <label>عنوان العمل :</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="fa fa-map-marker"></i></span>


                                                            </div>
                                                            <input type="text" class="form-control">

                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <label> كلمة المرور :</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="fa fa-lock"></i></span>


                                                            </div>
                                                            <input type="text" class="form-control">

                                                        </div>
                                                    </div>

                                                    <!-- /.col (right) -->

                                                </div>
                                                <!-- /.row -->

                                            </div><!-- /.container-fluid -->
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>


                    </div>

                </div>

            </div>
            <button type="submit" class="btn btn-primary" >تسجيل</button>

            <!-- /.content -->


        </section>
    </div>

    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/adminlte.js"></script>
@endsection
