<?php

namespace App\Http\Controllers\Admin;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Enfant;
use Charts;
use DB;
class CharrtController extends Controller
{
    public function __construct()
    {
        $this->middleware('auth');
    }

    public function index()
    {



       /* $users = Enfant::
        where(DB::raw("(DATE_FORMAT(created_at,'%Y'))"),date('Y'))
            ->get();*/

        $enfant = DB::table('enfants')
            ->where('sexe', 'like','%'.'أنثى'.'%' )
        ->get();
        $chart = Charts::database($enfant, 'bar', 'highcharts')
            ->title("Monthly new Register Users")
            ->elementLabel("Total Users")
            ->dimensions(1000, 500)
            ->responsive(false)
            ->groupByMonth(date('Y'), true);



        $enfant_pie = DB::table('enfants')
            ->where('sexe', 'like','%'.'أنثى'.'%' )
            ->get();
        $pie_chart  =   Charts::create($enfant_pie,'pie', 'highcharts')
            ->title('My nice chart')
            ->labels(['أنثى', 'ذكر', 'reste'])
            ->values([5,10,20])
            ->dimensions(1000,500)
            ->responsive(false);

        $us = Enfant::where(DB::raw("(DATE_FORMAT(created_at,'%Y'))"),date('Y'))
            ->get();
        $pie_cha  =   Charts::create('us','pie', 'highcharts')
            ->title('My nice chart')
            ->labels(['First', 'Second', 'Third'])
            ->values([5,10,20])
            ->dimensions(1000,500)
            ->responsive(false);

        $percentage_chart = Charts::create('percentage', 'justgage')
            ->title('My nice chart')
            ->elementLabel('My nice label')
            ->values([65,0,100])
            ->responsive(false)
            ->height(300)
            ->width(0);
        return view('admin.chart.index',compact('chart', 'pie_chart' ,'percentage_chart'));

    }


}
