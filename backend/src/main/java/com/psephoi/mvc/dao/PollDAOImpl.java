package com.psephoi.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psephoi.mvc.model.Poll;

@Repository
public class PollDAOImpl implements PollDAO {

   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
	public List<Poll> list() {
		return jdbcTemplate.query("SELECT * FROM poll", new BeanPropertyRowMapper<Poll>(Poll.class));
	}

	@Override
	public Poll get(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM poll WHERE id=?", new BeanPropertyRowMapper<Poll>(Poll.class), id);
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM poll WHERE id=?", id);
	}

	@Override
	public int save(Poll poll) {
		return jdbcTemplate.update("INSERT INTO poll (pollname, description, choice1, choice2, email) VALUES (?, ?, ?, ?, ?)", new Object[] {poll.getPollname(), poll.getDescription(), poll.getChoice1(), poll.getChoice2(), poll.getEmail()});
	}

	@Override
	public int update(Poll poll, int id) {
		return jdbcTemplate.update("UPDATE poll SET pollname = ?, description = ?, choice1 = ?, choice2 = ?, email = ? WHERE id = ?", new Object[] {poll.getPollname(), poll.getDescription(), poll.getChoice1(), poll.getChoice2(), poll.getEmail(), id});
	}

}