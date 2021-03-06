<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
<head>
    <title>${title}</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet"/>
    <link href="/static/css/app.css" rel="stylesheet"/>
</head>
<body>

<#--<ng-include src="'static/views/header.html'"></ng-include>-->
<div ui-view></div>
<script src="/static/js/libs/angular/angular.js"></script>
<script src="/static/js/libs/angular-ui-router/release/angular-ui-router.js"></script>
<script src="/static/js/libs/localforage/dist/localforage.js"></script>
<script src="/static/js/libs/ngstorage/ngStorage.js"></script>
<script src="/static/js/app/app.js"></script>
<script src="/static/js/app/UserService.js"></script>
<script src="/static/js/app/UserController.js"></script>
</body>
</html>