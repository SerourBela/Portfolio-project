@extends('layouts.app')
@section('content')
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3>قائمة اطفال التوحد</h3>
            </div>
        </div>

    <!--@if ($errors->any())
        <div class="alert alert-danger">
          <strong>Whoops! </strong> there where some problems with your input.<br>
          <ul>
@foreach ($errors as $error)
            <li>{{$error}}</li>
          @endforeach
                </ul>
              </div>
            @endif-->
            @if (count($errors)>0)
                <ul class="list-group">
                    @foreach ($errors ->all() as $error)
                        <li class="list-group-item text-danger ">
                            {{$error}}
                        </li>
                    @endforeach
                </ul>
            @endif

            <form action="{{route('enfant.store')}}" method="post">
                {{ csrf_field() }}
                <div class="row">
                    <div class="col-md-12">
                        <strong>: اللقب</strong>
                        <input type="text" class="form-control" placeholder="بوسطوح" name="prenom" >
                    </div>
                    <div class="col-md-12">
                        <strong>: الاسم</strong>
                        <input type="text" name="nom" class="form-control" placeholder="خولة">
                    </div>
                    <div class="col-md-12">
                        <strong>: تاريخ الميلاد</strong>
                        <input type="text" class="form-control" placeholder="2010-10-22" name="dateNaissance" >
                    </div>
                    <div class="col-md-12">
                        <strong>: مكان الميلاد</strong>
                        <input type="text" class="form-control" placeholder="عزابة" name="lieuNaissannce" >
                    </div>
                    <div class="col-md-12">
                        <strong>: الجنس</strong>
                        <input type="text" class="form-control" placeholder="أنثى" name="sexe" >
                    </div>
                    <div class="col-md-12">
                        <strong>: زمرة الدم</strong>
                        <input type="text" class="form-control" placeholder="A+" name="groupage" >
                    </div>
                    <div class="col-md-12">
                        <strong>: الولاية</strong>
                        <input type="text" class="form-control" placeholder="سكيكدة" name="wilaya" >
                    </div>
                    <div class="col-md-12">
                        <strong>: البلدية</strong>
                        <input class="form-control" placeholder="بكوش لخضر" name="commune">
                    </div>
                    <div class="col-md-12">
                        <strong>: العنوان</strong>
                        <input class="form-control" placeholder="حي 50 مسكن" name="domicile" >
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <strong>: اسم الأب</strong>
                            <input type="text" class="form-control"  name="nom" >
                        </div>
                        <div class="col-md-12">
                            <strong>: مستوى الدراسة</strong>
                            <input type="text" class="form-control"  name="niveauEduc" >
                        </div>
                        <div class="col-md-12">
                            <strong>: تاريخ الميلاد</strong>
                            <input type="text" class="form-control"  name="dateNaissance" >
                        </div>
                        <div class="col-md-12">
                            <strong>: رقم الهاتف</strong>
                            <input type="text" class="form-control"  name="numTel" >
                        </div>
                        <div class="col-md-12">
                            <strong>:عنوان العمل</strong>
                            <input type="text" class="form-control" name="lieuTravail" >
                        </div>
                        <div class="col-md-12">
                            <strong>:البريد الالكتروني</strong>
                            <input type="text" class="form-control"  name="email" >
                        </div>
                        <div class="col-md-12">
                            <strong>: كلمة المرور</strong>
                            <input type="text" class="form-control"  name="motpass" >
                        </div>
                        <div class="col-md-12">
                            <strong>: اسم الأم</strong>
                            <input type="text" class="form-control"  name="nomP" >
                        </div>
                        <div class="col-md-12">
                            <strong>: لقب الام</strong>
                            <input type="text" class="form-control"  name="prenomM" >
                        </div>
                        <div class="col-md-12">
                            <strong>: مستوى الدراسة</strong>
                            <input type="text" class="form-control"  name="lieuTravail" >
                        </div>
                        <div class="col-md-12">
                            <strong>: تاريخ الميلاد</strong>
                            <input type="text" class="form-control"  name="dateNaissance" >
                        </div>
                        <div class="col-md-12">
                            <strong>: رقم الهاتف</strong>
                            <input type="text" class="form-control"  name="numTel" >
                        </div>
                        <div class="col-md-12">
                            <strong>: مكان العمل</strong>
                            <input type="text" class="form-control"  name="lieuTravail" >
                        </div>
                        <div class="col-md-12">
                            <strong>:البريد الالكتروني</strong>
                            <input type="text" class="form-control"  name="email" >
                        </div>
                        <div class="col-md-12">
                            <strong>: كلمة المرور</strong>
                            <input type="text" class="form-control"  name="motpass" >
                        </div>
                        <div class="col-md-12">
                            <a href="{{route('enfant.index')}}" class="btn btn-sm btn-success">رجوع</a>
                            <button type="submit" class="btn btn-sm btn-primary">ارسال</button>
                        </div>
                    </div>
                </div>
            </form>

    </div>
@endsection
