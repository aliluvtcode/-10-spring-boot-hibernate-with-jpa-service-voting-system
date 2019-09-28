package com.luv2code.springboot.cruddemo.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Candidates;
import com.luv2code.springboot.cruddemo.entity.Citizens;
import com.luv2code.springboot.cruddemo.service.CandidatesService;
import com.luv2code.springboot.cruddemo.service.CitizensService;

@Controller
public class VotingController {

	private CitizensService citizensService;
	private CandidatesService candidatesService;

	@Autowired
	public VotingController(CitizensService theCitizensService, CandidatesService theCandidatesService) {
		citizensService = theCitizensService;
		candidatesService = theCandidatesService;
	}

	@RequestMapping("/")
	public String goToVote() {

		return "vote.html";

	}

	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam int pessel, @RequestParam String name, Model model, HttpSession session) throws ParseException {

		Citizens citizens = citizensService.findById(pessel);
		session.setAttribute("citizen", citizens);
//		citizensService.findByName(name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String BTD = "1997-05-10";
		Date checkBD = sdf.parse(BTD);

		if (citizens.getCitizen_BD().after(checkBD)) {
			return "/underage.html";
		} else {
			if (!citizens.getHasvoted()) {
				List<Candidates> candidates = candidatesService.findAllC();
				model.addAttribute("candidates", candidates);
				return "/performVoted.html";

			} else {
				return "/alreadyVoted.html";

			}
		}
	}

	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam int candidate_id , HttpSession session) {
		Citizens citizen =(Citizens)session.getAttribute("citizen");
		if(!citizen.getHasvoted()) {
			citizen.setHasvoted(true);
			citizensService.save(citizen);
		Candidates candidate=candidatesService.findByIdC(candidate_id);
		candidate.setNumber_of_votes(candidate.getNumber_of_votes()+1);
		candidatesService.saveC(candidate);
//		Citizens citizen=citizensService.findById(pessel);
		
		
		return "voted.html";
		
	}else {
		return "alreadyVoted.html";
	}

}
}