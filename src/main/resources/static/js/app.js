'use strict';
var app = angular.module("app", ['ngRoute', 'ngResource']);

app.config(['$routeProvider', '$locationProvider', '$resourceProvider', '$httpProvider',
    function ($routeProvider, $locationProvider, $resourceProvider, $httpProvider) {

        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'HomeController',
            controllerAs: 'ctrl'
        }).when('/login', {
            templateUrl: 'login.html',
            controller: 'NavigationController',
            controllerAs: 'ctrl'
        }).when('/main', {
            templateUrl: 'main.html',
            controller: 'MainController',
            controllerAs: 'ctrl'
        }).when('/cliente', {
            templateUrl: 'cliente.html',
            controller: 'ClienteController',
            controllerAs: 'ctrl'
        }).when('/cliente/:id', {
            templateUrl: 'cliente.html',
            controller: 'ClienteController',
            controllerAs: 'ctrl'
        }).when('/pedido/:id', {
            templateUrl: 'pedido.html',
            controller: 'PedidoController',
            controllerAs: 'ctrl'
        }).otherwise('/');

        // use the HTML5 History API
        $locationProvider.html5Mode(true);

        // use this to avoid traling slash removal with $resource
        $resourceProvider.defaults.stripTrailingSlashes = false;

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }]);

app.config(['$httpProvider',
    function ($httpProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    }
]);