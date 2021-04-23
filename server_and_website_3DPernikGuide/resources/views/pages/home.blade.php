@extends('layouts.app')

@section('content')
    <!-- Home-Area -->
    <header class="home-area overlay" id="home_page">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-7">
                    <div class="space-80 hidden-xs"></div>
                    <h1 class="wow fadeInUp" data-wow-delay="0.4s">Започнете своята виртуална
                        разходка с <strong>3DPernikGuide!</strong></h1>
                    <div class="space-20"></div>
                    <div class="desc wow fadeInUp" data-wow-delay="0.6s">
                        <p>Разгледайте най-известните туристически обекти, 3D модели, находки и
                            исторически артефакти на град Перник, с помощта на сканиране на QR
                            код.</p>
                    </div>
                    <div class="space-20"></div>
                    <a id="download-app" href="#download" class="btn-brown wow fadeInLeft scroll"
                       data-wow-delay="0.8s">
                        <i class="fa fa-download"></i> Изтеглете приложението
                    </a>
                </div>
                <div class="col-xs-12 hidden-sm col-md-5">
                    <figure class="mobile-image wow fadeInUp" data-wow-delay="0.2s">
                        <img src="images/launch.png" alt="">
                    </figure>
                </div>
            </div>
        </div>
    </header>
    <!-- Home-Area-End -->

    <!-- About-Area -->
    <section class="section-padding wow lightSpeedIn" id="about_page">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-10 col-md-offset-1">
                    <div class="page-title text-center">
                        <img class="about-project" src="images/logo.png" alt="About Logo">
                        <div class="space-20"></div>
                        <h5 class="title-default">Относно</h5> <strong>3DPernikGuide</strong>
                        <div class="space-30"></div>
                        <h3 class="brown-color">Цел и предназначение</h3>
                        <div class="space-20"></div>
                        <p><strong>3DPernikGuide</strong> представлява една виртуална разходка из
                            най-известните забележителности на град Перник. В нея се включват 3D
                            модели на находки и исторически артефакти, които могат да бъдат
                            разгледани с помощта на сканиране на QR код или засичане на геолокацията
                            на потребителя. Приложението цели да се покажат най-известните
                            забележителности на град Перник, чрез едни от най-модерните и
                            интерактивни технологии на двадесет и първи век, а именно 3D моделите и
                            тяхната визуализация.
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- About-Area-End -->

    <!-- Progress-Area -->
    <section class="progress-area gray-bg" id="progress_page">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="page-title section-padding">
                        <h3 class="dark-color wow fadeInUp" data-wow-delay="0.4s">Реален проект в действие</h3>
                        <div class="space-20"></div>
                        <div class="desc wow fadeInUp" data-wow-delay="0.6s">
                            <p>Този проект е създаден с помощта и съдействието на <strong> Регионален исторически музей - гр. Перник</strong>. Всички материали са от изследователски проучвания,
                            които са предоставени безвъзмездно от служителите на музея за НОИТ 2020.
                            </p>
                        </div>
                        <div class="space-20"></div>
                        <div class="desc wow fadeInUp" data-wow-delay="0.6s">
                            <p>
                                <a class="brown-color" href="https://www.museumpernik.com/" target="_blank"><strong>Регионален исторически музей - гр. Перник</strong></a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <figure class="mobile-image">
                        <img src="images/home-screen.png" alt="">
                    </figure>
                </div>
            </div>
        </div>
    </section>
    <!-- Progress-Area-End -->

    <!-- Feature-Area -->
    <section class="feature-area section-padding-top" id="features_page">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-sm-offset-2">
                    <div class="page-title text-center">
                        <h5 class="title">Качества на приложението</h5>
                        <div class="space-10"></div>
                        <h3>Супер добри качества както винаги</h3>
                        <div class="space-60"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="service-box wow fadeInUp" data-wow-delay="0.2s">
                        <div class="box-icon">
                            <i class="fa fa-rocket"></i>
                        </div>
                        <h4>Бързо &amp; Мощно</h4>
                        <p>Винаги разчитаме на бързина и мощност.</p>
                    </div>
                    <div class="space-60"></div>
                    <div class="service-box wow fadeInUp" data-wow-delay="0.4s">
                        <div class="box-icon">
                            <i class="fa fa-android"></i>
                        </div>
                        <h4>Лесно & Достъпно</h4>
                        <p>Достъпно по всяко време, а същевременно и лесно за употреба.</p>
                    </div>
                    <div class="space-60"></div>
                    <div class="service-box wow fadeInUp" data-wow-delay="0.6s">
                        <div class="box-icon">
                            <i class="fa fa-city"></i>
                        </div>
                        <h4>Полезно & Удобно</h4>
                        <p>Удобно за ползване и полезна информация, която може да научите за град
                            Перник.</p>
                    </div>
                    <div class="space-60"></div>
                </div>
                <div class="hidden-xs hidden-sm col-md-4">
                    <figure class="mobile-image">
                        <img src="images/feature.png" alt="Feature Photo">
                    </figure>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="service-box wow fadeInUp" data-wow-delay="0.2s">
                        <div class="box-icon">
                            <i class="fa fa-code"></i>
                        </div>
                        <h4>Иновативни технологии</h4>
                        <p>Съвременни методи за реализация, програмни езици и технологии.</p>
                    </div>
                    <div class="space-60"></div>
                    <div class="service-box wow fadeInUp" data-wow-delay="0.4s">
                        <div class="box-icon">
                            <i class="fa fa-balance-scale-right"></i>
                        </div>
                        <h4>Оптимизирано</h4>
                        <p>Оптимизирано за вашето андроид устройство.</p>
                    </div>
                    <div class="space-60"></div>
                    <div class="service-box wow fadeInUp" data-wow-delay="0.6s">
                        <div class="box-icon">
                            <i class="fa fa-quidditch"></i>
                        </div>
                        <h4>Прекрасен UI</h4>
                        <p>Добър дизайн, който да не е натрапчив, но същевременно да прави
                            приложението по-красиво.</p>
                    </div>
                    <div class="space-60"></div>
                </div>
            </div>
        </div>
    </section>
    <!-- Feature-Area-End -->

    <!-- Testimonial-Area -->
    <section class="testimonial-area" id="team">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-title text-center">
                        <h5 class="title">Отбор</h5>
                        <h3 class="dark-color">Хората, които създадоха този продукт:</h3>
                        <div class="space-60"></div>
                    </div>
                </div>
            </div>
            <div class="row wow flipInX" data-wow-delay="0.2s">
                <div class="team-slide">
                    <div class="col-md-6">
                        <div class="team-box">
                            <div class="team-image">
                                <img src="images/team-1.jpg" alt="">
                            </div>
                            <h4 class="text-center brown-color">Алекс Милчов</h4>
                            <h6 class="position text-center">Андроид приложение</h6>
                            <p class="text-center">Разработка, тестване, конфигуриране и управление
                                на
                                приложението.</p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="team-box">
                            <div class="team-image">
                                <img src="images/team-2.jpg" alt="">
                            </div>
                            <h4 class="text-center brown-color">Давид Иванов</h4>
                            <h6 class="position text-center">Сървър & Уебсайт</h6>
                            <p class="text-center">Разработка, тестване, конфигуриране и управление
                                на
                                сървъра и уебсайта.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Testimonial-Area-End -->

    <!-- Gallery-Area -->
    <section class="gallery-area section-padding wow bounce" id="gallery_page">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-6 gallery-slider">
                    <div class="gallery-slide">
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot1.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot2.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot3.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot4.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot5.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot6.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot7.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot8.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot9.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot10.jpg" alt="Screenshot">
                        </div>
                        <div class="item">
                            <img class="image-resize" src="images/screenshots/Screenshot11.jpg" alt="Screenshot">
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-5 col-lg-3">
                    <div class="page-title">
                        <h5 class="white-color title wow fadeInUp" data-wow-delay="0.2s">
                            Снимки от приложението</h5>
                        <div class="space-10"></div>
                    </div>
                    <div class="space-20"></div>
                    <div class="desc wow fadeInUp" data-wow-delay="0.6s">
                        <p>Тук можете да видите снимки от приложението, а ако искате да го
                            разгледате малко по-обстойно, можете да го изтеглите от бутона
                            по-долу.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Gallery-Area-End -->

    <!-- Technologies-Area -->
    <section class="section-padding" id="language-technologies">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-title text-center">
                        <h5 class="title">Езици & Технолгии</h5>
                        <h3 class="dark-color">Тук можете да видите част от езиците и технологиите,
                            които сме използвали за направата на този продукт:</h3>
                        <div class="space-60"></div>
                    </div>
                </div>
            </div>
            <div class="row wow zoomInUp" data-wow-delay="0.2s">
                <div class="team-slide">
                    <div class="col-md-6">
                        <div class="language-technologies-box">
                            <img class="language-technologies-image img-fluid" alt="PHP" src="images/languages_technologies/php.png">
                            <img class="language-technologies-image img-fluid" alt="Laravel" src="images/languages_technologies/laravel.png" >
                            <img class="language-technologies-image img-fluid" alt="Java" src="images/languages_technologies/java.png">
                            <img class="language-technologies-image img-fluid" alt="RxJava" src="images/languages_technologies/rxjava.png">
                            <img class="language-technologies-image img-fluid" alt="Json" src="images/languages_technologies/json.png">
                            <img class="language-technologies-image img-fluid" alt="Zxing" src="images/languages_technologies/zxing.png">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="language-technologies-box">
                            <img class="language-technologies-image img-fluid" alt="Android Jetpack" src="images/languages_technologies/androidjetpack.png">
                            <img class="language-technologies-image img-fluid" alt="MPAndroidChart" src="images/languages_technologies/mpandroidchart.png">
                            <img class="language-technologies-image img-fluid" alt="MySQL" src="images/languages_technologies/mysql.png">
                            <img class="language-technologies-image img-fluid" alt="SQLite" src="images/languages_technologies/sqlite.png">
                            <img class="language-technologies-image img-fluid" alt="OpenGL" src="images/languages_technologies/opengl.png">
                            <img class="language-technologies-image img-fluid" alt="Espresso" src="images/languages_technologies/espresso.png">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Technologies-Area-End -->

    <!-- Download-Area -->
    <div class="download-area wow zoomInLeft" id="download">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-6 hidden-sm">
                    <figure class="mobile-image">
                        <img src="images/launch.png" alt="">
                    </figure>
                </div>
                <div class="col-xs-12 col-md-6 section-padding">
                    <h3 class="white-color">Изтеглете приложението</h3>
                    <p>Ако желаете да видите всички неща в действие, можете да изтеглите
                        приложението, с което ще ни подкрепите и много ще ви
                        благодарим!</p>
                    <div class="space-60"></div>
                    <a class="btn-brown sq" href="apk/3DPernikGuide.apk" >
                        Изтегляне
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- Download-Area-End -->

    <!-- Questionnaire-Area -->
    <section id="questionnaire_page" class="questionnaire section-padding wow rotateInUpRight">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-12">
                    <div class="page-title text-center">
                        <h5 class="title">Анкета</h5>
                    </div>
                </div>
                <div class="col-xs-12 col-md-12">
                    <div class="page-title text-center">
                        <h5 class="brown-color">След като потвърдите анкетата, страницата ще се рестартира!</h5>
                    </div>
                </div>
            </div>
            <div class="google-form">
                <iframe
                    id="google-form"
                    class="map-iframe"
                    src="https://docs.google.com/forms/d/e/1FAIpQLSekxocdh1Eugytgjf25C43wDtEwFQF8qi1qoMrzr070KaJ6Nw/viewform?embedded=true"
                    width="100%"
                    height="2300px"
                    frameborder="0"
                    marginheight="0"
                    marginwidth="0"
                    onload="loaded()">
                    Зарежда се…
                </iframe>
            </div>
        </div>
    </section>
    <!-- Questionnaire-Area-End -->

    <!-- Contact-Area -->
    <section class="contacts section-padding wow swing">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-title text-center">
                        <h5 class="title">Контакти</h5>
                        <h3 class="dark-color">Свържете се с нас</h3>
                        <div class="space-60"></div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-7">
                    <form class="contact-form" method="POST" action="{{ route('contact') }}">
                        @csrf

                        @if (session('status'))
                            <div class="col-md-12">
                                <div id="alert-custom" class="alert alert-custom">
                                    {{ session('status') }}
                                </div>
                            </div>
                        @endif

                        <div class="col-md-6">
                            <div class="form-group">
                                <input class="form-control" id="first_name" name="first_name"
                                       type="text" placeholder="Име" required/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input class="form-control" id="last_name" name="last_name"
                                       type="text" placeholder="Фамилия" required/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input class="form-control" id="email" name="email" type="email"
                                       placeholder="Имейл" required/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input class="form-control" id="subject" name="subject" type="text"
                                       placeholder="Предмет на запитване" required/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <textarea class="form-control" rows="8" id="message" name="message"
                                          placeholder="Напишете съобщение" required></textarea>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-custom btn-block">Изпратете
                            </button>
                        </div>
                    </form>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-5">
                    <iframe class="map"
                            src="https://www.google.bg/maps/embed?pb=!1m14!1m8!1m3!1d1008.6882866409381!2d23.04723192140879!3d42.60621788676701!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x28028560258f88be!2z0J_RgNC-0YTQtdGB0LjQvtC90LDQu9C90LAg0LPQuNC80L3QsNC30LjRjyDQv9C-INC40LrQvtC90L7QvNC40LrQsA!5e0!3m2!1sbg!2sbg!4v1479811078314"></iframe>
                </div>
            </div>
            <div class="boxes">
                <div class="space-70"></div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="footer-box">
                            <div class="box-icon">
                                <i class="fa fa-phone-alt" aria-hidden="true"></i>
                            </div>
                            <p>+359896239867 <br/> +359893762009</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="footer-box">
                            <div class="box-icon">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </div>
                            <p>pernikguide@gmail.com</p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="footer-box">
                            <div class="box-icon">
                                <i class="fa fa-map-marker" aria-hidden="true"></i>
                            </div>
                            <p>Професионална гимназия по икономика <br/> ул. Георги Мамарчев 2</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact-Area-End -->
@endsection