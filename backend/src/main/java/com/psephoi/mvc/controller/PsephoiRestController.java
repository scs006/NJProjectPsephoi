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
import org.springframework.web.bind.annotation.CrossOrigin;


import com.psephoi.mvc.model.Poll;
import com.psephoi.mvc.dao.PollDAO;
 
@RestController
@CrossOrigin
public class PsephoiRestController {

   @Autowired
   private PollDAO pDAO;

   /*---Save poll---*/
   @PostMapping("/poll")
   public String save(@RequestBody Poll poll) {
      return pDAO.save(poll)+" Poll saved succesfully";
   }

   /*---Get poll by id---*/
   @GetMapping("/poll/{id}")
   public Poll get(@PathVariable int id) {
      	return pDAO.get(id);
   }

   /*---Get all polls---*/
   @GetMapping("/poll")
   public List<Poll> list() {
	   return pDAO.list();
   }

   /*---Update poll by id---*/
   @PutMapping("/poll/{id}")
   public String update(@RequestBody Poll poll, @PathVariable int id) {
   		return pDAO.update(poll, id)+" Poll has been updated successfully.";
   }

   /*---Delete poll by id---*/
   @DeleteMapping("/poll/{id}")
   public String delete(@PathVariable int id) {
	   return pDAO.delete(id)+"Poll has been deleted successfully.";
   }
   	
}   