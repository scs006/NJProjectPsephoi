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
import org.springframework.web.bind.annotation.CrossOrigin;


import com.psephoi.mvc.model.Poll;
import com.psephoi.mvc.manager.PollManager;
 
@RestController
@CrossOrigin(origins= "*", allowedHeaders = "*")
public class PsephoiRestController {

   @Autowired
   private PollManager pollManager;
   
   @CrossOrigin
   @RequestMapping(value = "/poll/" , method = RequestMethod.GET)
   public ResponseEntity<List<Poll>> list() {
       List<Poll> polls = pollManager.list();
       
       if(polls.isEmpty()){
           return new ResponseEntity<List<Poll>>(HttpStatus.NOT_FOUND);
       }
       
       return new ResponseEntity<List<Poll>>(polls, HttpStatus.OK);
   }
	
   @CrossOrigin
   @RequestMapping(value = "/poll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Poll> get(@PathVariable("id") Long id) {
   	System.out.println("Fetching Poll with id " + id);
       Poll poll = pollManager.get(id);
       if (poll == null) {
           System.out.println("Poll with id " + id + " not found");
           return new ResponseEntity<Poll>(HttpStatus.NOT_FOUND);
       }
       
       return new ResponseEntity<Poll>(poll, HttpStatus.OK);
   }
	
   @CrossOrigin
   @RequestMapping(value = "/poll/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Poll> update(@PathVariable("id") Long id, @RequestBody Poll poll) {
       Poll currentPoll = pollManager.get(id);

       currentPoll.setPollname(poll.getPollname());
       currentPoll.setDescription(poll.getDescription());
       currentPoll.setChoice1(poll.getChoice1());
       currentPoll.setChoice2(poll.getChoice2());
       currentPoll.setEmail(poll.getEmail());
         
       pollManager.update(currentPoll);
       
       return new ResponseEntity<Poll>(currentPoll, HttpStatus.OK);
   }
	
   @CrossOrigin
   @RequestMapping(value = "/poll/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Poll> delete(@PathVariable("id") Long id) {
       Poll poll = pollManager.get(id);
       pollManager.delete(id);
       
       return new ResponseEntity<Poll>(HttpStatus.NO_CONTENT);
   }
   
}