package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.CitizensDAO;
import com.luv2code.springboot.cruddemo.entity.Citizens;
@Service
public class CitizensServiceImpl implements CitizensService {
	
	private CitizensDAO citizensDAO;
	
	@Autowired
	public CitizensServiceImpl(@Qualifier("citizensDAOJpaImpl")CitizensDAO theCitizensDAO) {
		//we added @Qualifier("employeeDAOJpaImpl") to make the system qualify the DAO implemantation will use and also
		//we made copy best for the name of the DAOImpl but the first letter is small cuz the bean will understand it 
		citizensDAO= theCitizensDAO;
	}

	@Override
	@Transactional
	public List<Citizens> findAll() {
		// TODO Auto-generated method stub
		return citizensDAO.findAll();
	}

	@Transactional
	@Override
	public Citizens findById(int theId) {
		// TODO Auto-generated method stub
		return citizensDAO.findById(theId);
	}

	@Transactional
	@Override
	public void save(Citizens theEmployee) {
		// TODO Auto-generated method stub
		citizensDAO.save(theEmployee);

	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		citizensDAO.deleteById(theId);
		
	}

	@Override
	public Citizens findByName(String name) {
		// TODO Auto-generated method stub
		return citizensDAO.findByName(name);
	}



}
