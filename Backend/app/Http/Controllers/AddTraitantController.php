<?php

namespace App\Http\Controllers;

use App\Enfant;
use App\Seancetraitement;
use App\Traitant;
use Illuminate\Http\Request;

class AddTraitantController extends Controller
{
    public function index()
    {
        return view('admin.interfaceaddtraitant.addtraitant.addtraitant');

    }

}
