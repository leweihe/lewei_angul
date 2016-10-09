'use strict';

angular.module('myApp.map', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/map', {
    templateUrl: 'map/map.html',
    controller: 'MapCtrl'
  });
}])

.controller('MapCtrl', [function() {
  var map = new AMap.Map('mapContainer', {
    resizeEnable: true,
    zoom: 11,
    center: [116.397428, 39.90923]
  });
}]);