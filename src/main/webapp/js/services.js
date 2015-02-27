'use strict';

/* Services */

/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

 */

var services = angular.module('tradeIdea.services', ['ngResource']);


services.factory('TradeIdeasFactory', function ($resource) {
    return $resource('/rest/tradeIdeas', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('TradeIdeaFactory', function ($resource) {
    return $resource('/rest/tradeIdeas/:ticker', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {ticker: '@ticker'} },
        delete: { method: 'DELETE', params: {ticker: '@ticker'} }
    })
});
