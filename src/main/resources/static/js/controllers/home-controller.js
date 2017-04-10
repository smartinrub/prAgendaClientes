angular.module('app').controller("HomeController", ['$http', function ($http) {
        var self = this;
        $http.get('/resource/').then(function (response) {
           self.greeting = response.data; 
        });
    }]);