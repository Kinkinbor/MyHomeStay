(function (a) {
    a(document).ready(function () {
        a("#stars li").on("mouseover", function () {
            var c = parseInt(a(this).data("value"), 10);
            a(this).parent().children("li.star").each(function (d) {
                if (d < c) {
                    a(this).addClass("hover")
                } else {
                    a(this).removeClass("hover")
                }
            })
        }).on("mouseout", function () {
            a(this).parent().children("li.star").each(function (c) {
                a(this).removeClass("hover")
            })
        });
        a("#stars li").on("click", function () {
            var d = parseInt(a(this).data("value"), 10);
            var f = a(this).parent().children("li.star");
            for (i = 0; i < f.length; i++) {
                a(f[i]).removeClass("selected")
            }
            for (i = 0; i < d; i++) {
                a(f[i]).addClass("selected")
            }
            var e = parseInt(a("#stars li.selected").last().data("value"), 10);
            var c = "";
            if (e > 1) {
                c = "Thanks! You rated this " + e + " stars."
            } else {
                c = "We will improve ourselves. You rated this " + e + " stars."
            }
            b(c)
        })
    });

    function b(c) {
        alert(c)
    }
})(jQuery);