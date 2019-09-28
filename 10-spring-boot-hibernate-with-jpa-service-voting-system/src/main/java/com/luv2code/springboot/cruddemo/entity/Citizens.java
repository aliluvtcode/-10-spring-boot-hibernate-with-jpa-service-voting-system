package com.luv2code.springboot.cruddemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="citizens")
public class Citizens {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="citizen_pessel")
	private int citizen_pessel;
	
	@Column(name="citizen_name")
	private String citizen_name;
	
	
	@Column(name="hasvoted")
	private Boolean hasvoted;
	
	@Column(name="citizen_BD")
	private Date citizen_BD;
	
	public Citizens(){
		
		
	}

	public Citizens( String citizen_name, Boolean hasvoted, Date citizen_BD) {
		super();
		this.citizen_name = citizen_name;
		this.hasvoted = hasvoted;
		this.citizen_BD = citizen_BD;
	}



	public int getCitizen_pessel() {
		return citizen_pessel;
	}

	public void setCitizen_pessel(int citizen_pessel) {
		this.citizen_pessel = citizen_pessel;
	}

	public String getCitizen_name() {
		return citizen_name;
	}

	public void setCitizen_name(String citizen_name) {
		this.citizen_name = citizen_name;
	}

	

	public Boolean getHasvoted() {
		return hasvoted;
	}

	public void setHasvoted(Boolean hasvoted) {
		this.hasvoted = hasvoted;
	}

	public Date getCitizen_BD() {
		return citizen_BD;
	}

	public void setCitizen_BD(Date citizen_BD) {
		this.citizen_BD = citizen_BD;
	}

	@Override
	public String toString() {
		return "Citizens [citizen_pessel=" + citizen_pessel + ", citizen_name=" + citizen_name + ", hasvoted="
				+ hasvoted + ", citizen_BD=" + citizen_BD + "]";
	}
	
	
	
	
	
	
}
