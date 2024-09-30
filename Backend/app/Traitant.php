<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Traitant extends Model
{
    protected $primaryKey = "id_traitant";
    protected $fillable=['nom','user_id','prenom','dateNaissance','motpass','email','numTel','address','specialiste','image'];

    #region relationship:many to many
    public function seancetraitements(){
        return $this->hasMany('App\Seancetraitement');
    }
    public function notificationtraits(){
        return $this->hasMany('App\Notificationtrait');
    }
    public function user(){
        return $this->belongsTo(User::class);
    }

}
