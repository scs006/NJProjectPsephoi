package com.psephoi.mvc.dao;

import java.util.List;

import com.psephoi.mvc.model.Poll;


public interface PollDAO {
	
	long save(Poll poll);
	
	Poll get(long id);
	
	List<Poll> list();
	
	void update(long id, Poll poll);
	
	void delete(long id);
	
}
