var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE_URI: 'http://localhost:8080/',
    USER_SERVICE_API : 'http://localhost:8080/api/user/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/users',
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

