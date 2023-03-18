(function (a) {
    var b = function () {
        var L = "";
        var H = a(window).width();
        var y = function () {
            var O = jQuery("#quik-search-btn");
            var P = jQuery("#quik-search-remove");
            O.on("click", function () {
                jQuery(".dlab-quik-search").fadeIn(500);
                jQuery(".dlab-quik-search").addClass("On")
            });
            P.on("click", function () {
                jQuery(".dlab-quik-search").fadeOut(500);
                jQuery(".dlab-quik-search").removeClass("On")
            })
        };
        var C = function () {
            a(".filter-btn").on("click", function () {
                a(".filter-left").toggleClass("filter-on").toggleClass("filter-off")
            })
        };
        var d = function () {
            a(".item-close").on("click", function () {
                a(this).closest(".cart-item").hide("500")
            });
            a(".cart-btn").unbind().on("click", function () {
                a(".cart-list").slideToggle("slow")
            })
        };
        var E = function () {
            var O = parseInt(a(".onepage").css("height"), 10);
            a(".scroll").unbind().on("click", function (P) {
                P.preventDefault();
                if (this.hash !== "") {
                    var Q = this.hash;
                    var T = a(Q).offset().top;
                    var R = parseInt(a(".onepage").css("height"), 10);
                    a("body").scrollspy({target: ".navbar", offset: R + 2});
                    var S = T - (R);
                    a("html, body").animate({scrollTop: S}, 800, function () {
                    })
                }
            });
            a("body").scrollspy({target: ".navbar", offset: O + 2})
        };
        var u = function () {
            a(".header").css("height", "");
            var O = a(".header").height();
            a(".header").css("height", O)
        };
        var f = function () {
            if (H < 991) {
                if (a(".mo-left .header-nav").children(".logo-header").length == 0) {
                    var O = jQuery("<div>").append(a(".mo-left .logo-header").clone()).html();
                    jQuery(".mo-left .header-nav").prepend(O);
                    jQuery(".mo-left .header-nav .logo-header > a > img").attr("src", "static/image/logo-black.png");
                    jQuery(".mo-left.lw .header-nav .logo-header > a > img").attr("src", "static/image/logo-white.png")
                }
            } else {
                jQuery(".mo-left .header-nav .logo-header").remove();
                jQuery(".mo-left.lw .header-nav .logo-header").remove()
            }
            if (H <= 991) {
                jQuery(".navbar-nav > li > a, .sub-menu > li > a").unbind().on("click", function (P) {
                    if (jQuery(this).parent().hasClass("open")) {
                        jQuery(this).parent().removeClass("open")
                    } else {
                        jQuery(this).parent().parent().find("li").removeClass("open");
                        jQuery(this).parent().addClass("open")
                    }
                })
            }
        };
        var K = function () {
            if ((a(".setResizeMargin").length > 0) && H >= 1280) {
                var O = a(".container").width();
                var P = (H - O) / 2;
                a(".setResizeMargin").css("margin-left", P)
            }
        };
        var A = function () {
            jQuery(".mfp-gallery").magnificPopup({
                delegate: ".mfp-link",
                type: "image",
                tLoading: "Loading image #%curr%...",
                mainClass: "mfp-img-mobile",
                gallery: {enabled: true, navigateByImgClick: true, preload: [0, 1]},
                image: {
                    tError: '<a href="%url%">The image #%curr%</a> could not be loaded.', titleSrc: function (O) {
                        return O.el.attr("title") + "<small></small>"
                    }
                }
            });
            jQuery(".video").magnificPopup({
                type: "iframe",
                iframe: {markup: '<div class="mfp-iframe-scaler"><div class="mfp-close"></div><iframe class="mfp-iframe" frameborder="0" allowfullscreen></iframe><div class="mfp-title">Some caption</div></div>'},
                callbacks: {
                    markupParse: function (P, Q, O) {
                        Q.title = O.el.attr("title")
                    }
                }
            });
            a(".popup-youtube, .popup-vimeo, .popup-gmaps").magnificPopup({
                disableOn: 700,
                type: "iframe",
                mainClass: "mfp-fade",
                removalDelay: 160,
                preloader: false,
                fixedContentPos: false
            })
        };
        var I = function () {
            var O = jQuery("button.scroltop");
            O.on("click", function () {
                jQuery("html, body").animate({scrollTop: 0}, 1000);
                return false
            });
            jQuery(window).bind("scroll", function () {
                var P = jQuery(window).scrollTop();
                if (P > 900) {
                    jQuery("button.scroltop").fadeIn(1000)
                } else {
                    jQuery("button.scroltop").fadeOut(1000)
                }
            })
        };
        var k = function () {
            jQuery("#accordion").on("hidden.bs.collapse", function (O) {
                jQuery(O.target).prev(".panel-heading").find("i.indicator").toggleClass("glyphicon-minus glyphicon-plus")
            });
            jQuery("#accordion").on("shown.bs.collapse", function (O) {
                jQuery(O.target).prev(".panel-heading").find("i.indicator").toggleClass("glyphicon-minus glyphicon-plus")
            })
        };
        var s = function () {
            jQuery.support.placeholder = ("placeholder" in document.createElement("input"));
            if (!jQuery.support.placeholder) {
                jQuery("[placeholder]").on("focus", function () {
                    if (jQuery(this).val() == jQuery(this).attr("placeholder")) {
                        jQuery(this).val("")
                    }
                }).blur(function () {
                    if (jQuery(this).val() == "") {
                        jQuery(this).val(jQuery(this).attr("placeholder"))
                    }
                }).blur();
                jQuery("[placeholder]").parents("form").submit(function () {
                    jQuery(this).find("[placeholder]").each(function () {
                        if (jQuery(this).val() == jQuery(this).attr("placeholder")) {
                            jQuery(this).val("")
                        }
                    })
                })
            }
        };
        var t = function () {
            if (jQuery(".dezPlaceAni").length) {
                a("input, textarea").on("focus", function () {
                    a(this).parents(".form-group").addClass("focused")
                });
                a("input, textarea").on("blur", function () {
                    var O = a(this).val();
                    if (O == "") {
                        a(this).removeClass("filled");
                        a(this).parents(".form-group").removeClass("focused")
                    } else {
                        a(this).addClass("filled")
                    }
                })
            }
        };
        var g = function (P) {
            var R = 0, Q = 0, S = new Array(), O, T = 0;
            a(P).each(function () {
                O = a(this);
                a(O).height("auto");
                topPostion = O.position().top;
                if (Q != topPostion) {
                    for (currentDiv = 0; currentDiv < S.length; currentDiv++) {
                        S[currentDiv].height(R)
                    }
                    S.length = 0;
                    Q = topPostion;
                    R = O.height();
                    S.push(O)
                } else {
                    S.push(O);
                    R = (R < O.height()) ? (O.height()) : (R)
                }
                for (currentDiv = 0; currentDiv < S.length; currentDiv++) {
                    S[currentDiv].height(R)
                }
            })
        };
        var i = function () {
            jQuery(".site-footer").css("display", "block");
            jQuery(".site-footer").css("height", "auto");
            var O = jQuery(".site-footer").outerHeight();
            jQuery(".footer-fixed > .page-wraper").css("padding-bottom", O);
            jQuery(".site-footer").css("height", O)
        };
        var h = function () {
            jQuery(document).on("change", ".btn-file :file", function () {
                var O = jQuery(this);
                var Q = O.get(0).files ? O.get(0).files.length : 1;
                var P = O.val().replace(/\\/g, "/").replace(/.*\//, "");
                O.trigger("fileselect", [Q, P])
            });
            jQuery(".btn-file :file").on("fileselect", function (O, R, P) {
                input = jQuery(this).parents(".input-group").find(":text");
                var Q = R > 10 ? R + " files selected" : P;
                if (input.length) {
                    input.val(Q)
                } else {
                    if (Q) {
                        alert(Q)
                    }
                }
            })
        };
        var x = function () {
            jQuery(window).on("scroll", function () {
                if (jQuery(".sticky-header").length > 0) {
                    var O = jQuery(".sticky-header");
                    if (a(window).scrollTop() > O.offset().top) {
                        O.addClass("is-fixed");
                        a(".header-transparent .container > .logo-header .logo, .header-transparent .container-fluid > .logo-header .logo").attr("src", "static/image/logo-black.png")
                    } else {
                        O.removeClass("is-fixed");
                        a(".header-transparent .container > .logo-header .logo, .header-transparent .container-fluid > .logo-header .logo").attr("src", "static/image/logo-white.png")
                    }
                }
            })
        };
        var B = function () {
            if (jQuery("#masonry, .masonry").length) {
                var O = a("#masonry, .masonry");
                if (jQuery(".card-container").length) {
                    O.imagesLoaded(function () {
                        O.masonry({gutterWidth: 15, isAnimated: true, itemSelector: ".card-container"})
                    })
                }
            }
            if (jQuery(".filters").length) {
                jQuery(".filters").on("click", "li", function (P) {
                    P.preventDefault();
                    var Q = a(this).attr("data-filter");
                    O.masonryFilter({
                        filter: function () {
                            if (!Q) {
                                return true
                            }
                            return a(this).hasClass(Q)
                        }
                    })
                })
            }
        };
        var J = function () {
            var O = [];
            jQuery(".dzseth > div, .dzseth .img-cover, .dzseth .seth").each(function (P) {
                O.push(jQuery(this).height())
            });
            jQuery(".dzseth > div, .dzseth .img-cover, .dzseth .seth").each(function (P) {
                var Q = Math.max.apply(Math, O);
                jQuery(this).css("height", Q)
            });
            O = [];
            if (H < 991) {
                jQuery(".dzseth > div, .dzseth .img-cover, .dzseth .seth").each(function (P) {
                    jQuery(this).css("height", "")
                })
            }
        };
        var e = function () {
            if (jQuery(".counter").length > 0) {
                jQuery(".counter").counterUp({delay: 10, time: 3000})
            }
        };
        var w = function () {
            jQuery('iframe[src*="youtube.com"]').wrap('<div class="embed-responsive embed-responsive-16by9"></div>');
            jQuery('iframe[src*="vimeo.com"]').wrap('<div class="embed-responsive embed-responsive-16by9"></div>')
        };
        var r = function () {
            if (jQuery("#image-gallery-mix").length) {
                jQuery(".gallery-filter").find("li").each(function () {
                    a(this).addClass("filter")
                });
                jQuery("#image-gallery-mix").mixItUp()
            }
            if (jQuery(".gallery-filter.masonary").length) {
                jQuery(".gallery-filter.masonary").on("click", "span", function () {
                    var O = a(this).parent().attr("data-filter");
                    jQuery(".gallery-filter.masonary span").parent().removeClass("active");
                    jQuery(this).parent().addClass("active");
                    jQuery("#image-gallery-isotope").isotope({filter: O});
                    return false
                })
            }
        };
        var n = function () {
            if (jQuery("select").length) {
                jQuery("select").selectpicker()
            }
        };
        var o = function () {
            jQuery("input[name='demo_vertical2']").TouchSpin({
                verticalbuttons: true,
                verticalupclass: "ti-plus",
                verticaldownclass: "ti-minus"
            })
        };
        var l = function () {
            a(".full-height").css("height", a(window).height())
        };
        var p = function (O) {
            if (a(".countdown").length) {
                a(".countdown").countdown({date: O + " 23:5"}, function () {
                    a(".countdown").text("we are live")
                })
            }
        };
        var q = function () {
            if (a(".content-scroll").length) {
                a(".content-scroll").mCustomScrollbar({setWidth: false, setHeight: false, axis: "y"})
            }
        };
        var N = function () {
            if (a(".wow").length > 0) {
                var O = new WOW({boxClass: "wow", animateClass: "animated", offset: 50, mobile: false});
                O.init()
            }
        };
        var v = function () {
            a(".openbtn").on("click", function (O) {
                O.preventDefault();
                if (a("#mySidenav").length > 0) {
                    document.getElementById("mySidenav").style.left = "0"
                }
                if (a("#mySidenav1").length > 0) {
                    document.getElementById("mySidenav1").style.right = "0"
                }
            });
            a(".closebtn").on("click", function (O) {
                O.preventDefault();
                if (a("#mySidenav").length > 0) {
                    document.getElementById("mySidenav").style.left = "-300px"
                }
                if (a("#mySidenav1").length > 0) {
                    document.getElementById("mySidenav1").style.right = "-820px"
                }
            })
        };
        var F = function () {
            if (a(".price-slide, .price-slide-2").length > 0) {
                a("#slider-range-2").slider({
                    range: true,
                    min: 2,
                    max: 100,
                    type: "single",
                    value: a(this).find("input").val(),
                    animate: "slow",
                    values: [2, 100],
                    slide: function (O, R) {
                        var Q = R.values[0], P = R.values[1];
                        a("#distance").val(Q + "km - " + P + "km")
                    }
                })
            }
        };
        var m = function () {
            if (H > 1023) {
                if (jQuery(".bgeffect").length) {
                    var O = skrollr.init({
                        edgeStrategy: "set", easing: {
                            WTF: Math.random, inverted: function (P) {
                                return 1 - P
                            }
                        }
                    })
                }
            }
        };
        var c = function () {
            jQuery(".box-hover").on("mouseenter", function () {
                jQuery(".box-hover").removeClass("active");
                jQuery(this).addClass("active")
            })
        };
        var G = function () {
            var P = jQuery(this), O = P.find(".modal-dialog");
            P.css("display", "block");
            O.css("margin-top", Math.max(0, (jQuery(window).height() - O.height()) / 2))
        };
        var j = function () {
            jQuery(window).on("resize", function () {
                jQuery(".modal:visible").each(G);
                if (jQuery(".equal-wraper").length) {
                    g(".equal-wraper .equal-col")
                }
                i()
            })
        };
        var M = new Date();
        var D = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        M.setMonth(M.getMonth() + 1);
        M = M.getDate() + " " + D[M.getMonth()] + " " + M.getFullYear();
        var z = function () {
            if ((a("#lightgallery, .lightgallery").length > 0)) {
                a("#lightgallery, .lightgallery").lightGallery({
                    selector: ".check-km",
                    loop: true,
                    thumbnail: true,
                    exThumbImage: "data-exthumbimage"
                })
            }
        };
        return {
            init: function () {
                c();
                N();
                F();
                E();
                f();
                u();
                y();
                A();
                k();
                I();
                s();
                t();
                i();
                h();
                x();
                J();
                w();
                r();
                p(M);
                q();
                v();
                d();
                l();
                K();
                j();
                z();
                C();
                jQuery(".modal").on("show.bs.modal", G)
            }, load: function () {
                m();
                n();
                o();
                g(".equal-wraper .equal-col");
                e();
                B()
            }, resize: function () {
                H = a(window).width();
                f();
                u();
                v();
                J();
                K()
            }
        }
    }();
    jQuery(document).ready(function () {
        b.init();
        jQuery(".navicon").on("click", function () {
            a(this).toggleClass("open")
        });
        jQuery(".like-btn").on("click", function () {
            a(this).toggleClass("active")
        });
        a('a[data-toggle="tab"]').click(function () {
            a('a[data-toggle="tab"]').click(function () {
                a(a(this).attr("href")).show().addClass("show active").siblings().hide()
            })
        })
    });
    jQuery(window).on("load", function (c) {
        b.load();
        setTimeout(function () {
            jQuery("#loading-area").remove()
        }, 0)
    });
    jQuery(window).on("resize", function () {
        b.resize()
    })
})(jQuery);