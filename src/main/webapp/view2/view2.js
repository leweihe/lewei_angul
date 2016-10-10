'use strict';

angular.module('myApp.view2', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view2', {
            templateUrl: 'view2/view2.html',
            controller: 'View2Ctrl'
        });
    }])

    .controller('View2Ctrl', ['$scope', '$http', 'filterFilter', function ($scope, $http, filterFilter) {
        $http.get('app/rest/users/all').success(function (users) {
            $scope.users = users;
            $scope.filteredUsers = users;
        });
        $scope.filterString = "";
        $scope.doFilterChange = function (value) {
            $scope.filteredUsers = filterFilter($scope.users, $scope.filterString);
        };
    }]);