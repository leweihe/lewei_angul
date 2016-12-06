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
    .controller('manageStationCtrl', ['$scope', '$http', 'ManageStationService', function ($scope, $http, ManageStationService) {

        $scope.fromKeyWord = '松柏小学';

        var map = new AMap.Map('mapContainer2', {
            resizeEnable: true,
            zoom: 14,
            center: [118.139839, 24.488006]
        });
        $scope.searchPoint = function() {
            ManageStationService.searchPoint($scope.fromKeyWord);
        }

    }]).factory('ManageStationService', ['$rootScope', '$http', function($rootScope, $http) {

    return {searchPoint: function (keyWord) {
        $http.get('app/rest/busroute/all').success(function (busRoutes) {

            angular.forEach(busRoutes, function (busRoute, routeInd, busArray) {
                angular.forEach(busRoute.stations, function (station, stationInd, stationArray) {
                    AMap.plugin('AMap.Walking', function () {
                        var walking = new AMap.Walking();
                        walking.search([
                            {keyword: keyWord, city: '厦门市'},
                            {keyword: station.stationName, city: '厦门市'}
                        ], function (status, result) {
                            if ("error" === status) {
                                console.log(result);
                            }
                            if ('complete' === status) {
                                var dist = 0;
                                angular.forEach(result.routes, function (walkRoute, walkInd, walkArray) {
                                    dist += walkRoute.distance;
                                });
                                console.log("dist: " + dist);
                            }
                        });
                    });
                });
            });
        });
    }}
}]);