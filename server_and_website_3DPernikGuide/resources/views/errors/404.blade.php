@extends('errors.illustrated-layout')

@section('code', '404')

@section('title', 'Страницата не е намерена')

@section('image')
    <div class="error-page-image absolute pin bg-no-repeat md:bg-left lg:bg-center"></div>
@endsection

@section('message', __('За съжаление страницата, която търсите, не може да бъде намерена.'))

@section('button', 'Към началната страница')