package com.psephoi.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("pollname")
	private String pollname;

	@JsonProperty("description")
	private String description;

	@JsonProperty("choice1")
	private String choice1;

	@JsonProperty("choice2")
	private String choice2;
	
	@JsonProperty("email")
	private String email;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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