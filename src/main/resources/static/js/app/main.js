/*'use strict';
var App = angular.module('myApp',['ngAnimate', 'ngRoute', 'angularUtils.directives.dirPagination', 'oitozero.ngSweetAlert',
    '720kb.datepicker'])
    .config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {



        $locationProvider.hashPrefix('!');

        $routeProvider.
        when('/', {
            templateUrl: 'index'
        })
        when('/user', {
            templateUrl: '/list',
            controller:UserController,
            controllerAs:'userController'

        }).
        when('/user_report', {
            templateUrl: '/userReport'
        }).
        otherwise('/');

    }]).run(function($rootScope) {
        $rootScope.myDateFormat = "dd/MM/yyyy";
    });*/
