package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Candidates;


public interface CandidatesDAO {

	public List<Candidates> findAllC();
	
	public Candidates findByIdC(int theId);
	
	public void saveC(Candidates theCandidates);
	
	public void deleteByIdC(int theId);
		
}
