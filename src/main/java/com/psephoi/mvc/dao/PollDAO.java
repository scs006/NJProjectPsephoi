package com.psephoi.mvc.dao;

import java.util.List;

import com.psephoi.mvc.model.Poll;


public interface PollDAO {
	
	Long save(Poll poll);
	
	Poll get(long id);
	
	List<Poll> list();
	
	void update(Long id, Poll poll);
	
	void delete(Long id);
	
}
