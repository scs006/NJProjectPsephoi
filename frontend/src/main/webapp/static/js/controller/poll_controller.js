'use strict';

angular.module('myApp').controller('PollController', ['$scope', 'PollService', function($scope, PollService) {
    var self = this;
    self.poll={id:null,pollname:'',description:'',choice1:'',choice2:'',email:''};
    self.polls=[];
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllPolls();

    function fetchAllPolls(){
        PollService.fetchAllPolls()
            .then(
            function(d) {
                self.polls = d;
            },
            function(errResponse){
                console.error('Error while fetching Polls');
            }
        );
    }

    function createPoll(poll){
        PollService.createPoll(poll)
            .then(
            fetchAllPolls,
            function(errResponse){
                console.error('Error while creating Poll');
            }
        );
    }

    function updatePoll(poll, id){
        PollService.updatePoll(poll, id)
            .then(
            fetchAllPolls,
            function(errResponse){
                console.error('Error while updating Poll');
            }
        );
    }

    function deletePoll(id){
        PollService.deletePoll(id)
            .then(
            fetchAllPolls,
            function(errResponse){
                console.error('Error while deleting Poll');
            }
        );
    }

    function submit() {
        if(self.poll.id===null){
            console.log('Saving New Poll', self.poll);
            createPoll(self.poll);
        }else{
            updatePoll(self.poll, self.poll.id);
            console.log('Poll updated with id ', self.poll.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.polls.length; i++){
            if(self.polls[i].id === id) {
                self.poll = angular.copy(self.polls[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.poll.id === id) {//clean form if the poll to be deleted is shown there.
            reset();
        }
        deletePoll(id);
    }
		
    function reset(){
        self.poll={id:null,pollname:'',description:'',choice1:'',choice2:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}]);
