// (function (a) {
//     if (jQuery("#map3").length) {
//         function b() {
//             var d = document.getElementById("map3");
//             var e = {
//                 center: new qq.maps.LatLng(39.916527,116.397128),
//                 zoom: 11,
//                 // mapTypeId: google.maps.MapTypeId.TERRAIN,
//                 styles: [{
//                     featureType: "landscape",
//                     elementType: "all",
//                     stylers: [{hue: "#6600ff"}, {saturation: -11}]
//                 }, {
//                     featureType: "poi",
//                     elementType: "all",
//                     stylers: [{saturation: -78}, {hue: "#6600ff"}, {lightness: -47}, {visibility: "off"}]
//                 }, {
//                     featureType: "road",
//                     elementType: "all",
//                     stylers: [{hue: "#5e00ff"}, {saturation: -79}]
//                 }, {
//                     featureType: "road.local",
//                     elementType: "all",
//                     stylers: [{lightness: 30}, {weight: 1.3}]
//                 }, {
//                     featureType: "road.local",
//                     elementType: "labels",
//                     stylers: [{visibility: "simplified"}]
//                 }, {
//                     featureType: "transit",
//                     elementType: "all",
//                     stylers: [{visibility: "simplified"}, {hue: "#5e00ff"}, {saturation: -16}]
//                 }, {
//                     featureType: "transit.line",
//                     elementType: "all",
//                     stylers: [{saturation: -72}]
//                 }, {
//                     featureType: "water",
//                     elementType: "all",
//                     stylers: [{saturation: -65}, {hue: "#1900ff"}, {lightness: 8}]
//                 }]
//             };
//             var c = new qq.maps.Map(d, e)
//         }
//
//         qq.maps.event.addDomListener(window, "load", b)
//     }
// })(jQuery);