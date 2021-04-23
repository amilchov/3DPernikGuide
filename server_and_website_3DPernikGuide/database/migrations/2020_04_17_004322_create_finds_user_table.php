<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateFindsUserTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('finds_user', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->unsignedBigInteger('find_id');
            $table->unsignedBigInteger('user_id');
            $table->boolean('status');
            $table->foreign('find_id')->references('id')->on('finds');
            $table->foreign('user_id')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('finds_user');
    }
}
