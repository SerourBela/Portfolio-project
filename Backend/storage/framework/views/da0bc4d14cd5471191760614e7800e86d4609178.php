
<!DOCTYPE html>
<html >
<head>
    <title>تسجيل الدخول</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="<?php echo e(asset('https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css')); ?>">
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('dist/fonts/font-awesome-4.7.0/css/font-awesome.min.css')); ?>">
    <link href="<?php echo e(asset('https://fonts.googleapis.com/css2?family=Tajawal&display=swap')); ?>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<?php echo e(asset('dist/css/main.css')); ?>">


<style>
    input[type="email"]::placeholder {

        /* Firefox, Chrome, Opera */
        text-align: right;
    }
 input[type="password"]::placeholder {

        /* Firefox, Chrome, Opera */
        text-align: right;
    }

</style>
</head>

<body>

<div class="formpage">
    <div class="container-login">
        <div class="loginformpage">

            <div class="bckimg" style="background-image: url('<?php echo e(asset('dist/img/bg-02.jpg')); ?>');">
            </div>
            <form  method="POST" action="<?php echo e(route('login')); ?>" aria-label="<?php echo e(__('Login')); ?>" class="loginform validate-form">
                <?php echo csrf_field(); ?>
                <img src="<?php echo e(asset('dist/img/logo.png')); ?>" alt="logo" class="logo">

                <span class="login100-form-title">
						تسجيل الدخول
					</span>

                <div  data-validate = "يرجى إدخال البريد الإلكتروني">
                    <input  placeholder="البريد الإلكتروني" style="height: 80px;width: 445px;border-radius: 40px; background-color: #f7f7f7;" id="email" type="email"  class="form-control<?php echo e($errors->has('email') ? ' is-invalid' : ''); ?>"  value="<?php echo e(old('email')); ?>" name="email"  >
                    <?php if($errors->has('email')): ?>
                        <span class="invalid-feedback" role="alert">
                                        <strong><?php echo e($errors->first('email')); ?></strong>
                                    </span>
                    <?php endif; ?>

                </div>
                <br>
                <div data-validate="يرجى إدخال كلمة المرور  ">
                    <input  id="mypassword" placeholder="كلمة المرور"  type="password" class="form-control<?php echo e($errors->has('password') ? ' is-invalid' : ''); ?>" name="password" style="height: 80px;width: 445px;border-radius: 40px; background-color: #f7f7f7;" >
                    <?php if($errors->has('password')): ?>
                        <span class="invalid-feedback" role="alert">
                                        <strong><?php echo e($errors->first('password')); ?></strong>
                                    </span>
                    <?php endif; ?>
                </div>

                <div class="show w-full">
                    <div class="contact100-form-checkbox">
                        <input class="input-checkbox100" id="ckb1" type="checkbox" name="show-pass" onclick="myFunction()">
                        <label class="label-checkbox100" for="ckb1">
                            إظهار كلمة المرور
                        </label>
                    </div>

                    <div>
                        <a href="<?php echo e(route('password.request')); ?>" class="forgetpass">
                            هل نسيت كلمة المرور؟
                        </a>
                    </div>
                </div>


                <div class="container-login100-form-btn">
                    <button class="formbtn">
                        الدخول
                    </button>
                </div>
                <div class="footer">
                    <p class="footer-company-name" align="center"> 2020 &copy;
                        رانا معاك  </p>
                </div>

            </form>

        </div>

    </div>

</div>
</body>
</html>



<script>
    function myFunction() {
        var x = document.getElementById("mypassword");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    }
</script>
<script src="<?php echo e(asset('dist/jquery/jquery-3.2.1.min.js')); ?>"></script>
<script src="<?php echo e(asset('dist/bootstrap/js/bootstrap.min.js')); ?>"></script>

<script src="<?php echo e(asset('dist/js/main.js')); ?>"></script>




<?php /**PATH C:\Users\serour\Downloads\BackRanaMaeak\resources\views/auth/login.blade.php ENDPATH**/ ?>