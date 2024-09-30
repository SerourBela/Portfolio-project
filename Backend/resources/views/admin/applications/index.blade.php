@extends('layouts.admin')
@section('title','| قائمة الأطفال')
@section('content')
    <br>
    <br>

    <!-- /.content-header -->

            <p>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    اضافة تطبيق
                </button>
            </p>
            @if ($message = session('status'))
                <div class="alert alert-success">
                    <p>{{ $message }}</p>
                </div>
            @endif

            <table class="table table-bordered table-striped">
                <tr>
                    <th width="10%">الرقم</th>
                    <th  width = "35px">الاسم</th>
                    <th  width = "35px">الوصف</th>
                    <th width = "30px">الحركة</th>
                </tr>
                @if(count($exercices))
                    @foreach($exercices as $c   )
                        <tr>
                            <td>{{$loop->iteration}}</td>
                            <td>{{ $c->titre}}</td>
                            <td>{{ $c->description}}</td>
                            <td>

                                    <button  class="btn btn-info" data-mytitle="{{$c->titre}}" data-mydescription="{{$c->description}}" data-catid="{{$c->id_exercice}}" data-toggle="modal" data-target="#edit">تعديل</button>

                                <button class="btn btn-danger" data-catid="{{$c->id_exercice}}" data-toggle="modal" data-target="#delete">مسح</button>

                            </td>
                        </tr>

                    @endforeach

                @else
                    <tr><td colspan="4">لا يوجد تطبيق</td></tr>
                @endif
            </table>
            {{$exercices->render()}}

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" style="margin-left: 140px" id="myModalLabel">تطبيق جديد</h4>
                    <button type="button" style="margin-right: 195px" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <form action="{{route('admin.applications.store')}}" method="post">
                    {{csrf_field()}}
                    <div class="modal-body">
                        @include('admin.applications.form')
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">الغاء</button>
                        <button type="submit" class="btn btn-primary">حفظ</button>
                    </div>
                 </form>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" style="margin-left: 140px" id="myModalLabel">تعديل التطبيق</h4>

                    <button type="button" style="margin-right: 170px" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <form action="{{route('admin.applications.update','test')}}" method="post">
                    {{method_field('patch')}}
                    {{csrf_field()}}
                    @method('PATCH')
                    <div class="modal-body">
                        <input type="hidden" name="category_id" id="cat_id" value="">
                        @include('admin.applications.form')
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">الغاء</button>
                        <button type="submit" class="btn btn-primary">حفظ التغييرات</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal modal-danger fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title text-center" style="margin-left: 150px" id="myModalLabel">تأكيد الحذف</h4>

                    <button type="button" class="close" style="margin-right: 185px" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>

                </div>
                <form action="{{route('admin.applications.destroy','test')}}" method="post">
                    {{method_field('delete')}}
                    {{csrf_field()}}
                    <div class="modal-body">
                        <p class="text-center">
                           هل انت متأكد من الحذف؟
                        </p>
                        <input type="hidden" name="exercice_id" id="cat_id" value="">

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
