package com.psephoi.mvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psephoi.mvc.model.Poll;
import com.psephoi.mvc.service.PollService;
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PsephoiRestController {

   @Autowired
   private PollService pollService;

   @PostMapping("/poll")
   public ResponseEntity<?> save(@RequestBody Poll poll) {
      long id = pollService.save(poll);
      return ResponseEntity.ok().body("New Poll has been saved with ID:" + id);
   }

   /*---Get poll by id---*/
   @GetMapping("/poll/{id}")
   public ResponseEntity<Poll> get(@PathVariable("id") long id) {
      Poll poll = pollService.get(id);
      return ResponseEntity.ok().body(poll);
   }

   /*---get all polls---*/
   @GetMapping("/poll")
   public ResponseEntity<List<Poll>> list() {
      List<Poll> polls = pollService.list();
      return ResponseEntity.ok().body(polls);
   }

   /*---Update poll by id---*/
   @PutMapping("/poll/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Poll poll) {
      pollService.update(id, poll);
      return ResponseEntity.ok().body("Poll has been updated successfully.");
   }

   /*---Delete poll by id---*/
   @DeleteMapping("/poll/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      pollService.delete(id);
      return ResponseEntity.ok().body("Poll has been deleted successfully.");
   }
   	
}   