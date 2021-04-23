<?php

// Authentication Routes
Route::group(['namespace' => 'Api'], function () {
    Route::post('/register', 'AuthController@register');
    Route::post('/login', 'AuthController@login');
});

// Fortress Routes
Route::group(['prefix' => '/data/fortress/', 'namespace' => 'Api'], function () {
    Route::get('users', 'FortressUsersController@index');

    Route::middleware('verifyapitoken')->group(function () {
        Route::get('user', 'FortressUsersController@show');
        Route::match(['PUT', 'PATCH'], 'user/update', 'FortressUsersController@update');
    });
});

// Museum Routes
Route::group(['prefix' => '/data/museum/', 'namespace' => 'Api'], function () {
    Route::get('users', 'MuseumUsersController@index');

    Route::middleware('verifyapitoken')->group(function () {
        Route::get('user', 'MuseumUsersController@show');
        Route::match(['PUT', 'PATCH'], 'user/update', 'MuseumUsersController@update');
    });
});

// Finds Routes
Route::group(['prefix' => 'user', 'namespace' => 'Api'], function() {
    Route::middleware('verifyapitoken')->group(function () {
        Route::get('finds', 'FindsUserController@index');
        Route::match(['PUT', 'PATCH'], 'finds/update', 'FindsUserController@update');
    });
});