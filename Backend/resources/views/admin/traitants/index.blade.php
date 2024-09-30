@extends('layouts.admin')
@section('title','  |المعالجين')
@section('content')
<br>
<br>
    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">

            <p>

                <a href="{{route('addtraitant')}}" class="btn btn-primary">اضافة فرد جديد</a>

            </p>

        @if ($message = Session::get('success'))
                <div class="alert alert-success">
                    <p>{{ $message }}</p>
                </div>
            @endif
            <table class="table table-bordered table-striped">
                <tr>
                    <th width="10%">الصورة الشمسية</th>
                    <th width = "35px"> اللقب</th>
                    <th  width = "35px">الاسم</th>
                    <th  width = "35px">البريد الالكتروني</th>
                    <th width = "30px">الحركة</th>
                </tr>
                @if(count($traitants))
                @foreach($traitants as $c)
                    <tr>
                        <td><img src="{{ asset('storage/traitants/'.$c->image) }}" class="img-thumbnail"  width="50"  />
                        <td>{{ $c->prenom}}</td>
                        <td>{{ $c->nom}}</td>
                        <td>{{ $c->email}}</td>
                        <td>
                                <a href="{{route('admin.traitants.show',$c->id_traitant)}}" class="btn  btn-success">عرض</a>
                                <a href="{{route('admin.traitants.edit',$c->id_traitant)}}" class="btn btn-info">تعديل</a>
                                <button class="btn btn-danger" data-catid="{{$c->id_traitant}}" data-toggle="modal" data-target="#delete">مسح</button>
                        </td>
                    </tr>
                @endforeach
                @else
                    <tr><td colspan="5">لا يوجد معالج</td></tr>
                @endif
            </table>
            {{$traitants->render()}}
        </div>
    </section>
<div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <form action="{{route('admin.traitants.destroy','test')}}" method="post">
                {{method_field('delete')}}
                {{csrf_field()}}
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

@endsection
