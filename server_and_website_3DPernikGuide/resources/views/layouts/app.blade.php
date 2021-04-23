<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
<head>
    @include('partials.header')
</head>

<body data-spy="scroll" data-target=".mainmenu-area">
<!-- Navbar -->
    @include('partials.navbar')
<!-- Navbar-End -->

    @yield('content')

<!-- Footer -->
    @include('partials.footer')
<!-- Footer-End -->

<!-- JavaScript -->
    @include('partials.javascript')
<!-- JavaScript-End -->
</body>
</html>
