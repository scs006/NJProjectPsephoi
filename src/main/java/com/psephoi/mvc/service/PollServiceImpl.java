package com.psephoi.mvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.psephoi.mvc.model.Poll;

@Service("pollService")
public class PollServiceImpl implements PollService{
	
	private static Integer counter = 1;
	
	private static List<Poll> polls;
	
	static{
		polls= populateDummyPolls();
	}

	public List<Poll> findAllPolls() {
		return polls;
	}
	
	public Poll findById(long id) {
		for(Poll poll : polls){
			if(poll.getId() == id){
				return poll;
			}
		}
		return null;
	}
	
	public Poll findByName(String name) {
		for(Poll poll : polls){
			if(poll.getPollname().equalsIgnoreCase(name)){
				return poll;
			}
		}
		return null;
	}
	
	public void savePoll(Poll poll) {
		counter++;
		poll.setId(counter);
		polls.add(poll);
	}

	public void updatePoll(Poll poll) {
		int index = polls.indexOf(poll);
		polls.set(index, poll);
	}

	public void deletePollById(long id) {
		
		for (Iterator<Poll> iterator = polls.iterator(); iterator.hasNext(); ) {
		    Poll poll = iterator.next();
		    if (poll.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean hasPoll(Poll poll) {
		return findByName(poll.getPollname())!=null;
	}
	
	public void deleteAllPolls(){
		polls.clear();
	}

	private static List<Poll> populateDummyPolls(){
		List<Poll> polls = new ArrayList<Poll>();
		polls.add(new Poll(1,"Best Movie Genre", "Action movies or dramas?", "Action", "Drama","example@mail.com"));
		return polls;
	}
}
