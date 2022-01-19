package com.psephoi.mvc.dao;

import java.util.List;

import com.psephoi.mvc.model.Poll;


public interface PollDAO {
	
	public List<Poll> list();
	
	public Poll get(int id);
	
	public int delete(int id);
	
	public int save(Poll poll);
	
	public int update(Poll poll, int id);
	
}