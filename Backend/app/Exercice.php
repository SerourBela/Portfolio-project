<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Exercice extends Model
{
    protected $primaryKey = "id_exercice";

    protected $fillable=['titre','description'];
    #region relationship:one to many
    public function pratiques(){
        return $this->hasMany('App\Pratique');
    }

}
