'use strict';
$(document).ready(function () {

    var HeaderViewModel = {
        logout: function () {
            console.log('Logout!')
        }
    };

    var NavigationViewModel = {
        forward: function (url) {
            console.log(url)
            console.log('Forward To ' + url);
            ContentViewModel.url(url);
        }
    };

    var ContentViewModel = {
        url: ko.observable('http://www.163.com')
    };


    ko.applyBindings(HeaderViewModel, document.getElementById('header'));
    ko.applyBindings(NavigationViewModel, document.getElementById('nav'));
    ko.applyBindings(ContentViewModel, document.getElementById('content'));
});