package com.psephoi.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity (name= "Poll")
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;

	private String pollname;

	private String description;

	private String choice1;

	private String choice2;
	
	private String email;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPollname() {
		return pollname;
	}

	public void setPollname(String pollname) {
		this.pollname = pollname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
