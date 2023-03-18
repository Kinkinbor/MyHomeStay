(function (a) {
    function b() {
        window.verifyRecaptchaCallback = function (d) {
            a("input[data-recaptcha]").val(d).trigger("change")
        };
        window.expiredRecaptchaCallback = function () {
            a("input[data-recaptcha]").val("").trigger("change")
        };
        "use strict";
        var c;
        a(".dzForm").on("submit", function (g) {
            g.preventDefault();
            a(".dzFormMsg").html('<div class="gen alert alert-success">Submitting..</div>');
            var d = a(this).attr("action");
            var f = a(this).serialize();
            a.ajax({
                method: "POST", url: d, data: f, dataType: "json", success: function (e) {
                    if (e.status == 1) {
                        c = '<div class="gen alert alert-success">' + e.msg + "</div>"
                    }
                    if (e.status == 0) {
                        c = '<div class="err alert alert-danger">' + e.msg + "</div>"
                    }
                    a(".dzFormMsg").html(c);
                    a(".dzForm")[0].reset();
                    grecaptcha.reset()
                }
            })
        });
        setInterval(function () {
            a(".dzFormMsg .alert").hide(1000)
        }, 10000);
        a(".dzSubscribe").on("submit", function (g) {
            g.preventDefault();
            var d = a(this).attr("action");
            var f = a(this).serialize();
            a.ajax({
                method: "POST", url: d, data: f, dataType: "json", success: function (e) {
                    if (e.status == 1) {
                        c = '<p style="color: #34A853">' + e.msg + "</p>"
                    }
                    if (e.status == 0) {
                        c = '<p style="color: #EA4335">' + e.msg + "</p>"
                    }
                    a(".dzSubscribeMsg").html(c);
                    a(".dzSubscribe")[0].reset()
                }
            })
        });
        setInterval(function () {
            a(".dzSubscribeMsg p").hide(1000)
        }, 5000)
    }

    jQuery(document).ready(function () {
        b()
    })
})(jQuery);