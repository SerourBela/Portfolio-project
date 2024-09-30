<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateParenttsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('parentts', function (Blueprint $table) {
            $table->increments('id_parentt');
            $table->unsignedBigInteger('enfant_id');
            $table->unsignedBigInteger('user_id');
            $table->foreign('enfant_id')->references('id_enfant')->on('enfants')->onDelete('cascade');
            $table->string('nomp');
            $table->string('prenomp');
            $table->Date('dateNaissancep');
            $table->string('motpass');
            $table->string('numTel');
            $table->string('email')->unique();
            $table->string('niveauEduc');
            $table->string('lieuTravail');
            $table->string('img');
            $table->timestamps();
            $table->foreign('user_id')->references('id')
                ->on('users')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('parentts');
    }
}
