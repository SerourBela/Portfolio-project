@extends('layouts.admin')
@section('title','| قائمة الأطفال')
@section('content')

    <br>
    <br>

    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">
            <p>
                <a href="{{route('home')}}" class="btn btn-primary">اضافة فرد جديد</a>
            </p>
            @if ($message = Session::get('success'))
                <div class="alert alert-success">
                    <p>{{ $message }}</p>
                </div>
            @endif

            @if (session('status'))
                <div class="alert alert-success" role="alert">
                    {{ session('status') }}
                </div>
            @endif
            <table class="table table-bordered table-striped">
                <tr>
                    <th width="10%">الرقم</th>
                    <th width="10%">الصورة </th>
                    <th width = "35px"> اللقب</th>
                    <th  width = "35px">الاسم</th>
                    <th  width = "35px">الجنس</th>
                    <th  width = "35px">التاريخ</th>
                    <th width = "30px">الحركة</th>
                </tr>
                @if(count($enfants))
                    @foreach($enfants as $c   )
                        <tr>
                            <td>{{$c->id_enfant}}</td>

                            <td><img src="{{ asset('storage/enfants/'.$c->image) }}"  style="border-radius: 8px; display: block;
                                     margin-left: auto;
                                     margin-right: auto;  border: 2px solid #ddd;
                                     " width="50"  />
                            <td>{{ $c->prenom}}</td>
                            <td>{{ $c->nom}}</td>
                            <td>{{ $c->sexe}}</td>
                            <td>{{ date('Y,M j', strtotime($c->created_at)) }}</td>


                            <td>





                                    <a href="{{route('admin.enfants.show',$c->id_enfant)}}" class="btn  btn-success">عرض</a>

                                    <a href="{{route('admin.enfants.edit',$c->id_enfant)}}" class="btn btn-info">تعديل</a>

                                    <button class="btn btn-danger" data-catid="{{$c->id_enfant}}" data-toggle="modal" data-target="#delete">مسح</button>


                            </td>
                        </tr>

                    @endforeach

                @else
                    <tr><td colspan="7">لا يوجد طفل</td></tr>
                @endif
            </table>
            {{$enfants->render()}}
        </div>
    </section>
<div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

            </div>
            <form action="{{route('admin.enfants.destroy','test')}}" method="post">
                {{method_field('delete')}}
                {{csrf_field()}}
                <div class="modal-body">
                    <p class="text-center">
                        هل انت متأكد من الحذف؟
                    </p>
                    <input type="hidden" name="id_enfant" id="cat_id" value="">

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
