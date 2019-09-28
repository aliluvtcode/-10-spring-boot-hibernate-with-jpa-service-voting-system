package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.CandidatesDAO;
import com.luv2code.springboot.cruddemo.entity.Candidates;
@Service
public class CandidatesServiceImpl implements CandidatesService {
	
	private CandidatesDAO candidatesDAO;
	
	@Autowired
	public CandidatesServiceImpl(@Qualifier("candidatesDAOJpaImpl")CandidatesDAO theCandidatesDAO) {
		//we added @Qualifier("employeeDAOJpaImpl") to make the system qualify the DAO implemantation will use and also
		//we made copy best for the name of the DAOImpl but the first letter is small cuz the bean will understand it 
		candidatesDAO= theCandidatesDAO;
	}

	@Override
	@Transactional
	public List<Candidates> findAllC() {
		// TODO Auto-generated method stub
		return candidatesDAO.findAllC();
	}

	@Transactional
	@Override
	public Candidates findByIdC(int theId) {
		// TODO Auto-generated method stub
		return candidatesDAO.findByIdC(theId);
	}

	@Transactional
	@Override
	public void saveC(Candidates theEmployee) {
		// TODO Auto-generated method stub
		candidatesDAO.saveC(theEmployee);

	}

	@Transactional
	@Override
	public void deleteByIdC(int theId) {
		// TODO Auto-generated method stub
		candidatesDAO.deleteByIdC(theId);
		
	}


}
