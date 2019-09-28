package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Candidates;
import com.luv2code.springboot.cruddemo.entity.Citizens;
import com.luv2code.springboot.cruddemo.service.CandidatesService;
import com.luv2code.springboot.cruddemo.service.CitizensService;



@RestController
@RequestMapping("/api")
public class CitizensRestController {

	private CitizensService citizensService;
	private CandidatesService candidatesService;
	
	@Autowired
	public CitizensRestController(CitizensService theCitizensService , CandidatesService theCandidatesService) {
		citizensService = theCitizensService;
		candidatesService = theCandidatesService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/citizenss")
	public List<Citizens> findAll() {
		return citizensService.findAll();
	}

	@GetMapping("/citizenss/{CitizensCitizen_pessel}")
	public Citizens getEmployee(@PathVariable int CitizensCitizen_pessel) {
		Citizens theEmployee =citizensService.findById(CitizensCitizen_pessel);
	
		if(theEmployee==null) {
			throw new CustomerNotFoundException("Employee Id is not found- "+CitizensCitizen_pessel);
		}
		return theEmployee;
		
	}
	
	@PostMapping("/citizenss")
	public Citizens addEmployee(@RequestBody Citizens theEmployee) {
		
		
	//also just in case the pass an id in JSON set the id =0
	// this is force the hibernate session to save new item instead of making update on it 	
		theEmployee.setCitizen_pessel(0);//if the id null or 0 DAO will insert new customer 
		
		
		citizensService.save(theEmployee);
		
		
		return theEmployee;
		
	}
	
	//add the mapping PUT / customers - Update the customer
	@PutMapping("/citizenss")
	public Citizens updateCustomer(@RequestBody Citizens theEmployee) {

		citizensService.save(theEmployee);

	return theEmployee;



	}

	// add the mapping for GET/customers/{customerId}
	@DeleteMapping("/citizenss/{CitizensCitizen_pessel}")
	public String deleteEmployee(@PathVariable int CitizensCitizen_pessel){
		
		Citizens tempEmployee =citizensService.findById(CitizensCitizen_pessel);
		
		if((tempEmployee==null)){
			throw new CustomerNotFoundException("Employee id is not found- "+CitizensCitizen_pessel);
		
		}
		citizensService.deleteById(CitizensCitizen_pessel);
		
		//check the studentId against list size
		
		return "Deleted the employee id- "+CitizensCitizen_pessel;
		
		}
	


	
//	@Autowired
//	public CandidatesRestController(CandidatesService theCandidatesService) {
//		candidatesService = theCitizensService;
//	}
//	
	// expose "/employees" and return list of employees
	@GetMapping("/candidatess")
	public List<Candidates> findAllC() {
		return candidatesService.findAllC();
	}

	@GetMapping("/candidatess/{CandidatesCandidates_id}")
	public Candidates getCandidates(@PathVariable int CandidatesCandidates_id) {
		Candidates theEmployee =candidatesService.findByIdC(CandidatesCandidates_id);
	
		if(theEmployee==null) {
			throw new CustomerNotFoundException("Employee Id is not found- "+CandidatesCandidates_id);
		}
		return theEmployee;
		
	}
	
	@PostMapping("/candidatess")
	public Candidates addCandidates(@RequestBody Candidates theEmployee) {
		
		
	//also just in case the pass an id in JSON set the id =0
	// this is force the hibernate session to save new item instead of making update on it 	
		theEmployee.setCandidate_id(0);//if the id null or 0 DAO will insert new customer 
		
		
		candidatesService.saveC(theEmployee);
		
		
		return theEmployee;
		
	}
	
	//add the mapping PUT / customers - Update the customer
	@PutMapping("/candidatess")
	public Candidates updateCandidates(@RequestBody Candidates theEmployee) {

		candidatesService.saveC(theEmployee);

	return theEmployee;



	}

	// add the mapping for GET/customers/{customerId}
	@DeleteMapping("/candidatess/{CandidatesCandidates_id}")
	public String deleteCandidates(@PathVariable int CandidatesCandidate_id){
		
		Candidates tempEmployee =candidatesService.findByIdC(CandidatesCandidate_id);
		
		if((tempEmployee==null)){
			throw new CustomerNotFoundException("Employee id is not found- "+CandidatesCandidate_id);
		
		}
		candidatesService.deleteByIdC(CandidatesCandidate_id);
		
		//check the studentId against list size
		
		return "Deleted the employee id- "+CandidatesCandidate_id;
		
		}
	
	
	
}










