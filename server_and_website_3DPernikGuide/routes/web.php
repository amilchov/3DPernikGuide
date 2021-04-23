<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Pages Routes
Route::group(['namespace' => 'Pages'], function () {
    Route::get('/', 'PagesController@home')->name('home');
    Route::post('/', 'PagesController@contact')->name('contact');
});
