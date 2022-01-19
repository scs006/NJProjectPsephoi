package com.psephoi.mvc.manager;

import java.util.List;

import com.psephoi.mvc.model.Poll;


public interface PollManager {
	
	Poll save(Poll poll);
	
	Poll get(Long id);
	
	List<Poll> list();
	
	Poll update(Poll poll);
	
	void delete(Long id);
	
}
