/**
 * Created by cn40580 on 2016-10-12.
 */
'use strict';

angular.module('myApp.manageStation', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/manageStation', {
            templateUrl: 'manageStation/manageStation.html',
            controller: 'manageStationCtrl'
        });
    }])
    .controller('manageStationCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.fromKeyWord = '';

        var map = new AMap.Map('mapContainer2', {
            resizeEnable: true,
            zoom: 14,
            center: [118.139839, 24.488006]
        });

        $http.get('app/rest/busroute/all').success(function (busRoutes) {
            $scope.busRoutes = busRoutes;
            angular.forEach(busRoutes, function (busRoute, routeInd, busArray) {
                console.log("route " + routeInd + ": " + busRoute.routeName);
                angular.forEach(busRoute.stations, function (station, stationInd, stationArray) {
                    console.log("station " + stationInd + ": " + station.stationName);

                    AMap.plugin('AMap.Walking', function () {
                        var walking = new AMap.Walking({
                            map: map
                        });
                        walking.search([
                            {keyword: $scope.fromKeyWord, city: '厦门'},
                            [station.x, station.y]
                        ]);
                    });

                });
            });
        });

    }]);