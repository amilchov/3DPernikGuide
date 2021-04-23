setTimeout(function () {
    $('#alert-custom').fadeOut('fast');
}, 5000);

$("#download-app").click(function () {
    $('html, body').animate({
        scrollTop: $("#download").offset().top
    }, 2000);
});

$('li').click(function (event) {
    event.preventDefault();

    let link = $(this).children('a');

    $('html,body').animate({
        scrollTop: $(link.attr('href')).offset().top
    }, 1500);
});

let load = 0;

$("#google-form").load(function () {
    load++;

    if (load > 1) {
        document.getElementById('google-form').scrollIntoView();

        setTimeout(function () {
            $('.google-form').fadeOut('fast');

            window.location = "https://pernikguide.noit.eu";
        }, 3000);
    }
});

let loadCounter = 0;

let loaded = function () {
    loadCounter += 1;

    if (loadCounter === 2) {
        $("iframe").attr("height", "250px");
    }
}

$(() => {
    $(".expand").on("click", function () {

        let $expand = $(this).find(">:first-child");

        if ($expand.text() === "+") {
            $expand.text("-");
        }

        else {
            $expand.text("+");
        }
    });
});