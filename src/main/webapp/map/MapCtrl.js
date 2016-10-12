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
            zoom: 14,
            center: [118.139839, 24.488006]
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

        AMap.service(["AMap.Walking"], function() {
            var MWalk = new AMap.Walking({
                map: map,
                panel: "panel"
            }); //构造路线导航类
            //根据起终点坐标规划步行路线
            //MWalk.search([116.379028,39.865042], [116.427281,39.903719], function(status, result){
            MWalk.search([
                {keyword: 'sm 城市广场'},
                {keyword: '林德叉车'}
            ], function(status, result) {
            });
        });


    }]);