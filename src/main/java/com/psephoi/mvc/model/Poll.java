package com.psephoi.mvc.model;

public class Poll {

	private long id;
	
	private String pollname;
	
	private String description;
	
	private String choice1;
	
	private String choice2;
	
	private String email;
	
	public Poll(){
		id=0;
	}
	
	public Poll(long id, String pollname, String description, String choice1, String choice2, String email){
		this.id = id;
		this.pollname = pollname;
		this.description = description;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.email = email;
	}

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

	@Override
	public int hashCode() {
		final int prime = 89;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 89));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Poll))
			return false;
		Poll other = (Poll) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", pollname=" + pollname + ", description=" + description
				+ ", choice1=" + choice1 + ':' + ", choice2=" + choice2 + ':' + ", email=" + email + "]";
	}
	

	
}
