@extends('layouts.admin')

@section('content')
    <head>

        <title>Laravel 5 Chart example using Charts Package</title>

        <meta charset="utf-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="{{ asset('//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css')}}" rel="stylesheet">

        {!! Charts::assets() !!}

    </head>
    <div class="container">

        <div class="panel panel-primary">

            <div class="panel-heading">Charts In Laravel 5 Using Charts Package</div>

            <div class="panel-body">
                <div class="row">
                    <div class="col-md-6">
                        {!! $chart->html() !!}


                    </div>

                    <br/><br/>

                    <div class="col-md-6">
                        {!! $pie_chart->html() !!}
                    </div>

                    <br/><br/>

                    <div class="col-md-6">
                        {!! $line_chart->html() !!}
                    </div>

                    <br/><br/>

                    <div class="col-md-6">
                        {!! $areaspline_chart->html() !!}
                    </div>

                    <br/><br/>


                    <div class="col-md-6">
                        {!! $geo_chart->html() !!}
                    </div>

                    <br/><br/>


                    <div class="col-md-6">
                        {!! $area_chart->html() !!}
                    </div>

                    <br/><br/>

                    <div class="col-md-6">
                        {!! $donut_chart->html() !!}
                    </div>


                    <br/><br/>

                    <div class="col-md-6">
                        {!! $percentage_chart->html() !!}
                    </div>


                </div>

            </div>

        </div>
    </div>
    {!! Charts::scripts() !!}
    {!! $chart->script() !!}

    {!! $pie_chart->script() !!}

    {!! $line_chart->script() !!}

    {!! $areaspline_chart->script() !!}

    {!! $percentage_chart->script() !!}

    {!! $geo_chart->script() !!}

    {!! $area_chart->script() !!}

    {!! $donut_chart->script() !!}
@endsection
///////////////////////////////////////
@extends('layouts.admin')

@section('content')
    <head>

        <script src="{{ asset('https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js')}}"></script>
        <script type="text/javascript" src="{{ asset('https://www.gstatic.com/charts/loader.js')}}"></script>
        <link rel="stylesheet" href="{{ asset('https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css')}}" />
        <link rel="stylesheet" href="{{ asset('https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css')}}">


        <style type="text/css">
            .box{
                width:800px;
                margin:0 auto;
            }
        </style>
        <script type="text/javascript">
            var analytics = <?php echo $sexe; ?>

            google.charts.load('current', {'packages':['corechart']});

            google.charts.setOnLoadCallback(drawChart);

            function drawChart()
            {
                var data = google.visualization.arrayToDataTable(analytics);
                var options = {
                    title : 'النسبة المئوية للاناث و الذكور'
                };
                var chart = new google.visualization.PieChart(document.getElementById('pie_chart'));
                chart.draw(data, options);
            }
        </script>


    </head>
    <body>
    <br />
    <div class="container">
        <h3 align="center">احصائيات</h3><br />

        <div class="panel panel-default">

            <div class="panel-body" align="center">
                <div id="pie_chart" style="width:750px; height:450px;">

                </div>



                <div style="margin-top: 150px;"></div>
                <div class="panel-body">
                    <div id="chart" style="width: 100%; height: 600px;"></div>
                </div>
            </div>
        </div>
    </div>

    <!--  ************************************part 2 **************************************************************************!-->
    <script src="{{ asset('https://raw.githubusercontent.com/nnnick/Chart.js/master/dist/Chart.bundle.js')}}"></script>
    <script>
        var year = ['2013','2014','2015', '2016'];
        var data_viewer = <?php echo $viewer; ?>;


        var barChartData = {
            labels: year,
            datasets: [ {
                label: 'View',
                backgroundColor: "rgba(151,187,205,0.5)",
                data: data_viewer
            }]
        };


        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myBar = new Chart(ctx, {
                type: 'bar',
                data: barChartData,
                options: {
                    elements: {
                        rectangle: {
                            borderWidth: 2,
                            borderColor: 'rgb(0, 255, 0)',
                            borderSkipped: 'bottom'
                        }
                    },
                    responsive: true,
                    title: {
                        display: true,
                        text: 'Yearly Website Visitor'
                    }
                }
            });


        };
    </script>


    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">Dashboard</div>
                    <div class="panel-body">
                        <canvas id="canvas" height="280" width="600"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>





@endsection
