@extends('layouts.app')
@section('content')

    @foreach($enfants as $e )

        <label> {{$e->id_enfant}}</label>
        @endforeach

    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3>قائمة المعالحين</h3>
            </div> ?
        </div>

        @if ($errors->any())
            <div class="alert alert-danger">
                <strong>Whoops! </strong> there where some problems with your input.<br>
                <ul>
                    @foreach ($errors as $error)
                        <li>{{$error}}</li>
                    @endforeach
                </ul>
            </div>
        @endif

        <form action="{{route('traitant.store')}}" method="post">
            {{ csrf_field() }}
            <div class="row">
                <div class="col-md-12">

                    <label class="col-md-4 text-right">Select Profile Image</label>
                    <div class="col-md-8">
                        <input type="file" name="image" />
                    </div>
                </div>
                <div class="col-md-12">
                    <strong>: اللقب</strong>
                    <input type="text" class="form-control" placeholder="بوسطوح" name="prenom" ></textarea>
                </div>
                <div class="col-md-12">
                    <strong>: الاسم</strong>
                    <input type="text" name="nom" class="form-control" placeholder="خولة">
                </div>
                <div class="col-md-12">
                    <strong>: تاريخ الميلاد</strong>
                    <input type="text" class="form-control" placeholder="2010-10-22" name="dateNaissance" ></textarea>
                </div>
                <div class="col-md-12">
                    <strong>:الرقم السري </strong>
                    <input type="text" class="form-control" placeholder="?@23167" name="motpass" ></textarea>
                </div>
                <div class="col-md-12">
                    <strong>: البريد الالكتروني</strong>
                    <input type="text" class="form-control" placeholder="mail@gmail.com" name="email" ></textarea>
                </div>

                <div class="col-md-12">
                <label for="cars">Choose a car:</label>

                <select id="cars" multiple>
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="opel">Opel</option>
                    <option value="audi">Audi</option>
                </select>
                </div>
                <div class="col-md-12">
                    <strong>: رقم الهاتف</strong>
                    <input type="text" class="form-control" placeholder="07.78.56.46.99" name="numTel" ></textarea>
                </div>
                <div class="col-md-12">
                    <strong>:العنوان </strong>
                    <textarea class="form-control" placeholder="مكان السكن" name="address" rows="5" cols="80"></textarea>
                </div>
                <div class="col-md-12">
                    <strong>: تخصص</strong>
                    <textarea class="form-control" placeholder="تخصص" name="spécialiste" rows="5" cols="80"></textarea>
                </div>

                <div class="col-md-12">
                    <a href="{{route('traitant.index')}}" class="btn btn-sm btn-success">رجوع</a>
                    <button type="submit" class="btn btn-sm btn-primary">ارسال</button>
                </div>
            </div>
        </form>

    </div>
@endsection
