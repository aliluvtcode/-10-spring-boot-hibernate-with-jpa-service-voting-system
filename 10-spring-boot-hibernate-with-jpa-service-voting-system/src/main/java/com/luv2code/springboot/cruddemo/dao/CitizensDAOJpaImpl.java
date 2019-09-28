package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Citizens;

@Repository
public class CitizensDAOJpaImpl implements CitizensDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public CitizensDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager= theEntityManager;
	}

	@Override
	public List<Citizens> findAll() {
		//create a query
		Query theQuery =
				entityManager.createQuery("from Citizens");
		
		//execute the query 
		List<Citizens> citizen=theQuery.getResultList();
		
		//return the list
		return citizen;
	}

	@Override
	public Citizens findById(int theId) {
		Citizens theCitizen = entityManager.find(Citizens.class, theId);
		return theCitizen;
	}

	//save or update 
	@Override
	public void save(Citizens theCitizens) {
		Citizens dbEmployee=entityManager.merge(theCitizens);
		theCitizens.setCitizen_pessel(dbEmployee.getCitizen_pessel());
		

	}

	@Override
	public void deleteById(int theId) {
		Query theQuery =
				entityManager.createQuery("delete from Citizens where citizen_pessel=:citizensCitizen_pessel");
		theQuery.setParameter("citizensCitizen_pessel", theId);
		theQuery.executeUpdate();

	}

	@Override
	public Citizens findByName(String name) {
		Citizens theCitizen = entityManager.find(Citizens.class, name);
		return theCitizen;
	}

//	@Override
//	public Citizens findById(int theId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void save(Citizens theCitizen) {
//		// TODO Auto-generated method stub
//		
//	}

}
