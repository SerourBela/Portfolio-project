@extends('layouts.admin')
@section('title','  |المشخصين ')
@section('content')
    <br>
    <br>

    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">
            <p>
                <a href="{{route('addspecialiste')}}" class="btn btn-primary">اضافة فرد جديد</a>
            </p>

            @if ($message = Session::get('success'))
                <div class="alert alert-success">
                    <button type="button" class="close"
                            data-dismiss="alert" aria-hidden="true">&times;
                    </button>
                    <p>{{ $message }}</p>
                </div>
            @endif
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
                @if(count($carsspecialistes))
                    @foreach($carsspecialistes as $c)
                        <tr>
                            <td>{{ $c->id_carsspecialiste}}</td>
                            <td><img src="{{ asset('storage/specialistes/'.$c->image) }}"  style="border-radius: 8px; display: block;
                                     margin-left: auto;
                                     margin-right: auto;  border: 2px solid #ddd;
                                     " width="50"  />

                            <td>{{ $c->nom}}</td>
                            <td>{{ $c->prenom}}</td>
                            <td>{{ $c->email}}</td>
                            <td>{{ $c->numTel}}</td>
                            <td>


                                    <a href="{{route('admin.carsSpecialistes.show',$c->id_carsspecialiste)}}" class="btn  btn-success">عرض</a>

                                    <a href="{{route('admin.carsSpecialistes.edit',$c->id_carsspecialiste)}}" class="btn btn-info">تعديل</a>

                                    <button class="btn btn-danger" data-catid="{{$c->id_carsspecialiste}}" data-toggle="modal" data-target="#delete">مسح</button>
                            </td>
                        </tr>
                    @endforeach
                @else
                    <tr><td colspan="7">لا يوجد مشخص</td></tr>
                @endif
            </table>
        </div>
        <div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                        <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                    </div>
                    <form action="{{route('admin.carsSpecialistes.destroy','test')}}" method="post">
                        {{method_field('delete')}}
                        {{csrf_field()}}
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
@endsection
