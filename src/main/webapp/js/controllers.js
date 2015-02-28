'use strict';

/* Controllers */

var app = angular.module('tradeIdea.controllers', [])
.factory('SessionService', function($q, $http) {
  var service = {
    user_id: null,
    getCurrentUser: function() {
      debugger; // Set the debugger inside 
                // this function
      return service.user_id;
    }
  }
    return service;
})
;


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('TradeIdeaListCtrl', ['$scope', 'TradeIdeasFactory', 'TradeIdeaFactory', '$location',
    function ($scope, TradeIdeasFactory, TradeIdeaFactory, $location) {

        // callback for ng-click 'editTradeIdea':
        $scope.editTradeIdea = function (ticker) {
            $location.path('/tradeIdea-detail/' + ticker);
        };

        // callback for ng-click 'deleteTradeIdea':
        $scope.deleteTradeIdea = function (ticker) {
        	TradeIdeaFactory.delete({ id: ticker });
            $scope.tradeIdeas = TradeIdeasFactory.query();
        };

        // callback for ng-click 'createTradeIdea':
        $scope.createNewTradeIdea = function () {  	
        	$location.path('/tradeIdea-creation');
        };

        $scope.springTradeIdeaViews = TradeIdeasFactory.query();
    }]);

app.controller('TradeIdeaDetailCtrl', ['$scope', '$routeParams', 'TradeIdeaFactory', '$location',
      function ($scope, $routeParams, TradeIdeaFactory, $location) {

          // callback for ng-click 'updateUser':
          $scope.updateTradeIdea = function () {
        	  TradeIdeaFactory.update($scope.tradeIdea);
              $location.path('/tradeIdea-list');
          };

          // callback for ng-click 'cancel':
          $scope.cancel = function () {
              $location.path('/tradeIdea-list');
          };

          $scope.springTradeIdeaViews = TradeIdeaFactory.show({ticker: $routeParams.ticker});
      }]);

  app.controller('TradeIdeaCreationCtrl', ['$scope', 'TradeIdeasFactory', '$location',
          function ($scope, TradeIdeasFactory, $location) {
	  			
	  		  // callback for ng-click 'createNewUser':
              $scope.createNewTradeIdea = function () {
            	  TradeIdeasFactory.create($scope.springTradeIdea);	
                  $location.path('/tradeIdea-list');
              }
             
              $scope.springTradeIdea.chartTimeFrames = [{name:'Daily'},{name:'Daily & Weekly'},{name:'30 minutes'},{name:'5 minutes'} ];
              $scope.springTradeIdea.chartTimeFrame = $scope.springTradeIdea.chartTimeFrames[0];
            //$scope.timeFrames = [{name:'Daily'},{name:'Daily & Weekly'},{name:'30 minutes'},{name:'5 minutes'} ];
  			$scope.sources = [{name:'Kirk Prospector'},{name:'My watch'},{name:'Bespoke'},{name:'Kirk watch'} ];
  			$scope.patterns = [{name:'C&H'},{name:'H&S'},{name:'Channel'},{name:'Bull Flag'},{name:'Bear Flag'},{name:'Inv C&H'},{name:'Inv H&S'} ];
              
              
          }]);

