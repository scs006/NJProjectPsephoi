package com.psephoi.mvc.service;

import java.util.List;

import com.psephoi.mvc.model.Poll;



public interface PollService {
	
	Poll findById(long id);
	
	Poll findByName(String name);
	
	void savePoll(Poll poll);
	
	void updatePoll(Poll poll);
	
	void deletePollById(long id);

	List<Poll> findAllPolls(); 
	
	void deleteAllPolls();
	
	public boolean hasPoll(Poll poll);
	
}
