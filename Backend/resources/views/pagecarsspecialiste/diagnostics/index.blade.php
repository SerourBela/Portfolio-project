@extends('layouts.specialistes')
@section('title','| قائمة اطفال حصة معالجة')
@section('content')
    <br>

    <br>

    <!-- /.content-header -->
    <section class="content">
        <div class="container-fluid">

            <div class="panel-body">


                @if ($message = Session::get('success'))
                    <div class="alert alert-success">
                        <p>{{ $message }}</p>
                    </div>
                @endif
                <table class="table table-bordered table-striped">
                    <tr>
                        <th width="6%">الرقم</th>
                        <th width="10%">الصورة </th>
                        <th  width = "30px">اللقب</th>
                        <th  width = "30px">الاسم</th>
                        <th  width = "30px">الجنس</th>



                    </tr>
                    @if(count($enfants))
                        @foreach($enfants as $c)

                            <tr  data-href="{{route('pagecarsspecialiste.affiche',$c->id_enfant)}}" style="cursor: pointer;">
                                <td>{{$c->id_enfant}}</td>
                                <td value="{{$c->id_enfant}}"><img src="{{ asset('storage/enfants/'.$c->image) }}"  style="border-radius: 8px; display: block;
                                     margin-left: auto;
                                     margin-right: auto;  border: 2px solid #ddd;
                                     " width="50"  />
                                <td value="{{$c->id_enfant}}">{{ $c->prenom}} </td>
                                <td value="{{$c->id_enfant}}">  {{ $c->nom}}</td>

                                <td>{{ $c->sexe}}</td>



                            </tr>

                        @endforeach

                    @else
                        <tr><td colspan="7">لا يوجد طفل</td></tr>
                    @endif
                </table>
                {{$enfants->render()}}
            </div>
        </div>               </section>
    <script>
        document.addEventListener("DOMContentLoaded",()=>{
            const rows=document.querySelectorAll("tr[data-href]");
            rows.forEach(row=>{
                row.addEventListener("click",()=>{
                    window.location.href=row.dataset.href;
                });

            });
        });

        /* $(document).ready(function () {
             $(document.body).on("click","tr[data-href]",function () {
                 window.location.href=this.dataset.href;

             });

         });*/
    </script>
    <script type="text/javascript">
        $("tr").not(':first').hover(
            function () {
                $(this).css("background","#fef5d5");
            },
            function () {
                $(this).css("background","");
            }

        );

    </script>
    <script type="text/javascript">
        function passvalues(){
            var idenf=document.getElementById("idEnfant").value;
            localStorage.setItem("idenfvalue",idenf);
            return false;
        }
    </script>
    <script type="text/javascript">
        $('#search').on('keyup',function(){
            $value=$(this).val();
            $.ajax({
                type : 'get',
                url :  '{{URL::to('/pagecarsspecialiste/diagnostics/search')}}',
                data:{'search':$value},
                success:function(data){
                    $('tbody').html(data);
                }
            });
        })
    </script>



@endsection
