package com.psephoi.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(
		value =	"/pollresult",
		method = {RequestMethod.GET, RequestMethod.POST})

public class ResultController {
	
	  @RequestMapping(method = RequestMethod.GET)
	  	public String getResultPage() {
		  	return "PollResult";
	  }	
	
}