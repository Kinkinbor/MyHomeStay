(function (a) {
    jQuery(document).ready(function () {
        jQuery(".blog-carousel").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 30,
            nav: true,
            dots: false,
            navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 991: {items: 2}, 1000: {items: 3}}
        });
        jQuery(".popular-cities-carousel").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 8,
            nav: true,
            dots: false,
            navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 991: {items: 3}, 1000: {items: 4}}
        });
        jQuery(".most-visite").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 20,
            center: true,
            nav: true,
            dots: false,
            navText: ['<i class="la la-angle-left"></i>', '<i class="la la-angle-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 991: {items: 2}, 1000: {items: 4}, 1200: {items: 5}}
        });
        jQuery(".testimonial-one").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 0,
            nav: true,
            center: true,
            dots: true,
            navText: ['<i class="la la-angle-left"></i>', '<i class="la la-angle-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 1}, 767: {items: 1}, 1000: {items: 3}}
        });
        jQuery(".testimonial-one").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 0,
            nav: true,
            center: true,
            dots: true,
            navText: ['<i class="la la-angle-left"></i>', '<i class="la la-angle-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 1}, 767: {items: 1}, 1000: {items: 3}}
        });
        jQuery(".popular-list").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 30,
            nav: true,
            dots: false,
            navText: ['<i class="fa fa-arrow-left"></i>', '<i class="fa fa-arrow-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 767: {items: 3}, 1200: {items: 4}}
        });
        jQuery(".testimonial-six").owlCarousel({
            loop: true,
            margin: 0,
            center: true,
            nav: false,
            dots: true,
            navText: ['<i class="fa fa-arrow-left"></i>', '<i class="fa fa-arrow-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 991: {items: 2}, 1000: {items: 3}}
        });
        jQuery(".client-logo-carousel").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 30,
            nav: true,
            dots: false,
            navText: ['<i class="fa fa-arrow-left"></i>', '<i class="fa fa-arrow-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 767: {items: 3}, 1000: {items: 5}}
        });
        jQuery(".owl-location-carousel").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 3,
            nav: true,
            dots: false,
            navText: ['<i class="la la-arrow-left"></i>', '<i class="la la-arrow-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 767: {items: 3}, 1000: {items: 3}, 1200: {items: 4}}
        });
        jQuery(".client-carousel").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 30,
            nav: true,
            dots: false,
            navText: ['<i class="fa fa-arrow-left"></i>', '<i class="fa fa-arrow-right"></i>'],
            responsive: {0: {items: 1}, 480: {items: 2}, 767: {items: 3}, 1000: {items: 4}}
        });
        jQuery(".listing-slider").owlCarousel({
            loop: true,
            autoplay: true,
            margin: 0,
            stagePadding: 220,
            nav: true,
            dots: false,
            navText: ['<i class="la la-angle-left"></i>', '<i class="la la-angle-right"></i>'],
            responsive: {
                0: {items: 1, stagePadding: 0,},
                480: {items: 1, stagePadding: 0,},
                767: {items: 1, stagePadding: 0,},
                1024: {items: 1, stagePadding: 0,},
                1200: {items: 1}
            }
        })
    })
})(jQuery);