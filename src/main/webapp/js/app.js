'use strict';

// Declare app level module which depends on filters, and services
angular.module('tradeIdea', ['tradeIdea.filters', 'tradeIdea.services', 'tradeIdea.directives', 'tradeIdea.controllers']).
    config(['$routeProvider', function ($routeProvider) {        
        $routeProvider.when('/tradeIdea-list', {templateUrl: 'tradeIdea-list.html', controller: 'TradeIdeaListCtrl'});
        $routeProvider.when('/tradeIdea-detail/:id', {templateUrl: 'tradeIdea-detail.html', controller: 'TradeIdeaDetailCtrl'});
        $routeProvider.when('/tradeIdea-creation', {templateUrl: 'tradeIdea-creation.html', controller: 'TradeIdeaCreationCtrl'});
        
    }]);
