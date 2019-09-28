package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Candidates;

@Repository
public class CandidatesDAOJpaImpl implements CandidatesDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public CandidatesDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager= theEntityManager;
	}

	@Override
	public List<Candidates> findAllC() {
		//create a query
		Query theQuery =
				entityManager.createQuery("from Candidates");
		
		//execute the query 
		List<Candidates> candidates=theQuery.getResultList();
		
		//return the list
		return candidates;
	}

	@Override
	public Candidates findByIdC(int theId) {
		Candidates theCitizen = entityManager.find(Candidates.class, theId);
		return theCitizen;
	}

	//save or update 
	@Override
	public void saveC(Candidates theCitizens) {
		Candidates dbEmployee=entityManager.merge(theCitizens);
		theCitizens.setCandidate_id(dbEmployee.getCandidate_id());
		

	}

	@Override
	public void deleteByIdC(int theId) {
		Query theQuery =
				entityManager.createQuery("delete from Candidates where Candidates_id=:citizensCitizen_pessel");
		theQuery.setParameter("citizensCitizen_pessel", theId);
		theQuery.executeUpdate();

	}


}
