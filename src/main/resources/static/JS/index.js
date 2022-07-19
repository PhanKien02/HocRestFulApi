Api = "http://localhost:8080/Product"

$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/Product"
    }).then(function (data) {
        console.log(data.category);
        $('.categoryProduct').append(append(data.category));
    });
});