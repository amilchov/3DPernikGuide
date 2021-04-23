(function ($) {
    "use strict";

    $(".carousel-inner .item:first-child").addClass("active");

    /* Mobile menu click then remove */
    $(".mainmenu-area #primary_menu li a").on("click", function () {
        $(".navbar-collapse").removeClass("in");
    });

    /* Scroll to top */
    $.scrollUp({
        scrollText: '<i class="fa fa-arrow-up"></i>',
        easingType: 'linear',
        scrollSpeed: 700,
        animation: 'fade'
    });

    /* Testimonials Slider Active */
    $('.gallery-slide').owlCarousel({
        loop: true,
        margin: 0,
        responsiveClass: true,
        nav: false,
        autoplay: true,
        autoplayTimeout: 4000,
        smartSpeed: 1000,
        responsive: {
            0: {
                items: 1,
            },
            500: {
                items: 2
            },
            1280: {
                items: 3
            },
            1500: {
                items: 4
            }
        }
    });

    /* Smooth-Scroll */
    $('.mainmenu-area a[href*="#"]')
        .not('[href="#"]')
        .not('[href="#0"]')
        .click(function (event) {
            if (
                location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') &&
                location.hostname === this.hostname
            ) {
                let target = $(this.hash);

                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');

                if (target.length) {
                    event.preventDefault();

                    $('html, body').animate({
                        scrollTop: target.offset().top
                    }, 1000, () => {
                        let $target = $(target);

                        $target.focus();

                        if ($target.is(":focus")) {
                            return false;
                        }

                        else {
                            $target.attr('tabindex', '-1'); // Adding tabindex for elements not focusable
                            $target.focus(); // Set focus again
                        }
                    });
                }
            }
        });

    /* Preloader Js */
    $(window).on("load", function () {
        $('.preloader').fadeOut(500);

        new WOW().init({
            mobile: false,
        });
    });
})(jQuery);
