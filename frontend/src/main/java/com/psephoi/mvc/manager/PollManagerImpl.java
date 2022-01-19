package com.psephoi.mvc.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.psephoi.mvc.model.Poll;

@Service
public class PollManagerImpl implements PollManager{
	
	private final String restURL = "http://localhost:8080/";
	
	@Autowired
	private RestTemplate restTemplate; 

	
	public List<Poll> list() {
		String requestUri  = restURL + "poll/";
		Poll[] response = restTemplate.getForObject(requestUri , Poll[].class);
		List<Poll> polls = new ArrayList<>();
		
		for(Poll poll : response) {
			polls.add(poll);
		}
		
		return polls;
	}

	
	public Poll save(Poll poll) {
		String requestUri  = restURL + "poll/";
		restTemplate.postForObject(requestUri , poll, Poll.class);
		return poll;
	}
	
	
	public Poll update(Poll poll) {
		String requestUri  = restURL + "poll/{id}";
		Map<String, String> params = new HashMap<>();
		params.put("id", Long.toString(poll.getId()));
		restTemplate.put(requestUri, poll, params);
		
		return poll;
	}	

	
	public Poll get(Long id) {
		String requestUri  = restURL + "poll/{id}";
		Map<String, String> params = new HashMap<>();
		params.put("id", Long.toString(id));
		
		return restTemplate.getForObject(requestUri , Poll.class, params);
	}

	
	public void delete(Long id) {
		String requestUri  = restURL + "poll/{id}";
		Map<String, String> params = new HashMap<>();
		params.put("id", Long.toString(id));
		
		restTemplate.delete(requestUri, params);
	}

}
