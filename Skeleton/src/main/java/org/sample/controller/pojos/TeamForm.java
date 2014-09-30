package org.sample.controller.pojos;

public class TeamForm {
	
	private String teamName;
	private Long id;
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String name) {
		this.teamName = name;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
}