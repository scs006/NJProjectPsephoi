package com.psephoi.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pollview")
public class Verification {
	
	  @RequestMapping(method = RequestMethod.GET)
	  	public String getPollView() {
		  	return "PollView";
	  }	
	
}