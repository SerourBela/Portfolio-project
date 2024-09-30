<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateCarsspecialistesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('carsspecialistes', function (Blueprint $table) {
            $table->bigIncrements('id_carsspecialiste');
            $table->unsignedBigInteger('user_id');
            $table->string('nom');
            $table->string('prenom');
            $table->Date('dateNaissance');
            $table->string('email')->unique();
            $table->string('motpass');
            $table->string('numTel');
            $table->string('address');
            $table->string('specialite');
            $table->string('image');
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
        Schema::dropIfExists('carsspecialistes');
    }
}
