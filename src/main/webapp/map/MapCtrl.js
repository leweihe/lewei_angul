'use strict';

angular.module('myApp.map', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/map', {
            templateUrl: 'map/map.html',
            controller: 'MapCtrl'
        });
    }])
    .controller('MapCtrl', ['$scope', function ($scope) {

        var map = new AMap.Map('mapContainer', {
            resizeEnable: true,
            zoom: 12
        });

        $scope.setMapStyle = function (mapStyle) {
            map.setMapStyle(mapStyle);
        };

        $scope.doSearchDrivingPath = function () {
            AMap.plugin('AMap.Driving', function () {
                var drving = new AMap.Driving({
                    map: map
                })
                drving.search([
                    {keyword: $scope.fromLocation, city: '厦门'},
                    {keyword: $scope.tolocation, city: '厦门'}
                ]);
            })
        };
    }]);