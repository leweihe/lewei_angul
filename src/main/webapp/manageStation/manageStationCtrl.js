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

        $scope.fromKeyWord = '松柏小学';

        var map = new AMap.Map('mapContainer2', {
            resizeEnable: true,
            zoom: 14,
            center: [118.139839, 24.488006]
        });

        $scope.searchPoint = function (value) {
            $http.get('app/rest/busroute/all').success(function (busRoutes) {
                $scope.busRoutes = busRoutes;
                angular.forEach(busRoutes, function (busRoute, routeInd, busArray) {
                    angular.forEach(busRoute.stations, function (station, stationInd, stationArray) {
                        var dist = 0;
                        var tmpDist = 0;
                        AMap.plugin('AMap.Walking', function () {
                            var walking = new AMap.Walking();
                            walking.search([
                                {keyword: $scope.fromKeyWord, city: '厦门'},
                                [station.x, station.y]
                            ], function (status, result) {
                                console.log("info: " + result.info);
                                console.log("route: " + routeInd + ": " + busRoute.routeName);
                                console.log("station: " + stationInd + ": " + station.stationName + ", x: " + station.x + ", y: " + station.y);
                                console.log("count : " + result.count);
                                angular.forEach(result.routes, function (walkRoute, walkInd, walkArray) {
                                    dist += walkRoute.distance;
                                });
                                if (stationInd == 0) {
                                    tmpDist = dist;
                                } else {
                                    if (tmpDist > dist) {
                                        tmpDist = dist;
                                    }
                                }
                                console.log("result.origin: " + result.origin + ", result.origin: " + result.destination + ", result.route: " + result.routes );
                                console.log("dist: " + dist + ", station: " + station.stationName);
                            });
                        });
                    });
                });
            });
        };


    }]);