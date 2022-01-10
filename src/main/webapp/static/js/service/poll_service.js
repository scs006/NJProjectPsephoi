'use strict';

angular.module('myApp').factory('PollService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/api/poll/';

    var factory = {
        fetchAllPolls:fetchAllPolls,
        createPoll:createPoll,
        updatePoll:updatePoll,
        deletePoll:deletePoll
    };

    return factory;

    function fetchAllPolls() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
				console.log(response)
				console.log(response.data)
            },
            function(errResponse){
                console.error('Error while fetching Polls');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createPoll(poll) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, poll)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Poll');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updatePoll(poll, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, poll)
            .then(
            function (response) {
                deferred.resolve(response.data);
				console.log(response.data)
				console.log(response)
            },
            function(errResponse){
                console.error('Error while updating Poll');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deletePoll(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Poll');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
