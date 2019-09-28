package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Citizens;


public interface CitizensDAO {

	public List<Citizens> findAll();
	
	public Citizens findById(int theId);
	
	public void save(Citizens theCitizen);
	
	public void deleteById(int theId);

	public Citizens findByName(String name);
		
}
