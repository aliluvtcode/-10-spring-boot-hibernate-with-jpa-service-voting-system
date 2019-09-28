package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidates")
public class Candidates {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="candidate_id")
	private int candidate_id;
	
	@Column(name="candidate_name")
	private String candidate_name;
	
	@Column(name="numbers_of_votes")
	private int number_of_votes;
	
	public Candidates() {
		
		
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public int getNumber_of_votes() {
		return number_of_votes;
	}

	public void setNumber_of_votes(int number_of_votes) {
		this.number_of_votes = number_of_votes;
	}

	@Override
	public String toString() {
		return "Candidates [candidate_id=" + candidate_id + ", candidate_name=" + candidate_name
				+ ", number_of_votes=" + number_of_votes + "]";
	}
	
	
	
	

}
