<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class AddspecialisteController extends Controller
{
    public function index()
    {
        return view('admin.interfaceaddspecialiste.addspecialiste.addspecialist');

    }
    public function trait()
    {
        return view('pagecarsspecialiste.carsSpecialistes.create');    }

}
