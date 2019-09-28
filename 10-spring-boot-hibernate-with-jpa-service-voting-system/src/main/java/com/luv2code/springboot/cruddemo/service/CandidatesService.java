package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Candidates;

public interface CandidatesService {
	
public List<Candidates> findAllC();
	
	public Candidates findByIdC(int theId);
	
	public void saveC(Candidates theCitizen);
	
	public void deleteByIdC(int theId);

}
