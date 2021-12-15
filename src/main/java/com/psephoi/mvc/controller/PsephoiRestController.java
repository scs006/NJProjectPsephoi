package com.psephoi.mvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.psephoi.mvc.model.Poll;
import com.psephoi.mvc.service.PollService;
 
@RestController
public class PsephoiRestController {
 
    @Autowired
    PollService pollService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Polls--------------------------------------------------------
     
    @RequestMapping(value = "/poll/", method = RequestMethod.GET)
    public ResponseEntity<List<Poll>> listAllPolls() {
        List<Poll> polls = pollService.findAllPolls();
        if(polls.isEmpty()){
            return new ResponseEntity<List<Poll>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Poll>>(polls, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Poll--------------------------------------------------------
     
    @RequestMapping(value = "/poll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Poll> getPoll(@PathVariable("id") long id) {
        System.out.println("Fetching Poll with id " + id);
        Poll poll = pollService.findById(id);
        if (poll == null) {
            System.out.println("Poll with id " + id + " not found");
            return new ResponseEntity<Poll>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Poll>(poll, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Poll--------------------------------------------------------
     
    @RequestMapping(value = "/poll/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPoll(@RequestBody Poll poll,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Poll " + poll.getPollname());
 
        if (pollService.hasPoll(poll)) {
            System.out.println("A Poll with name " + poll.getPollname() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        pollService.savePoll(poll);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/poll/{id}").buildAndExpand(poll.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Poll --------------------------------------------------------
     
    @RequestMapping(value = "/poll/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Poll> updatePoll(@PathVariable("id") long id, @RequestBody Poll poll) {
        System.out.println("Updating Poll " + id);
         
        Poll currentPoll = pollService.findById(id);
         
        if (currentPoll==null) {
            System.out.println("Poll with id " + id + " not found");
            return new ResponseEntity<Poll>(HttpStatus.NOT_FOUND);
        }
 
        currentPoll.setPollname(poll.getPollname());
        currentPoll.setDescription(poll.getDescription());
        currentPoll.setChoice1(poll.getChoice1());
        currentPoll.setChoice2(poll.getChoice2());
        currentPoll.setEmail(poll.getEmail());
         
        pollService.updatePoll(currentPoll);
        return new ResponseEntity<Poll>(currentPoll, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Poll --------------------------------------------------------
     
    @RequestMapping(value = "/poll/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Poll> deletePoll(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Poll with id " + id);
 
        Poll poll = pollService.findById(id);
        if (poll == null) {
            System.out.println("Unable to delete. Poll with id " + id + " not found");
            return new ResponseEntity<Poll>(HttpStatus.NOT_FOUND);
        }
 
        pollService.deletePollById(id);
        return new ResponseEntity<Poll>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Polls --------------------------------------------------------
     
    @RequestMapping(value = "/poll/", method = RequestMethod.DELETE)
    public ResponseEntity<Poll> deleteAllPolls() {
        System.out.println("Deleting All Polls");
 
        pollService.deleteAllPolls();
        return new ResponseEntity<Poll>(HttpStatus.NO_CONTENT);
    }
 
}