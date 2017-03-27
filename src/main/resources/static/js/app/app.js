var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE_URI: 'http://localhost:8085/',
    USER_SERVICE_API : 'http://localhost:8085/api/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
           /* .state('home', {
                url: '/',
                templateUrl: 'index',
                controller:'AppController',
                controllerAs:'appController',
                resolve: {
                    hello: function () {
                        console.log('Welcome to Angular JS Routing YO party');

                    }
                }
            })*/
           // .state('home.user', {
            .state('user', {
              //  url: '/user',
                  url:'/',
                templateUrl: 'partials/list',
                controller:'UserController',
                controllerAs:'userController',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

    