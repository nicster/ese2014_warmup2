package org.sample.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String teamName;
	private Timestamp creationDate;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getTeamName () {
		return teamName;
	}
	
	public void setTeamName(String name) {
		this.teamName = name;
	}
	
	public Timestamp getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Timestamp date) {
		this.creationDate = date;
	}
	
}