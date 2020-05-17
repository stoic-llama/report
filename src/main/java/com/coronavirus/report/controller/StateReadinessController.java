package com.coronavirus.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coronavirus.report.model.MobilityStats;
import com.coronavirus.report.service.CoronaVirusDataService;
import com.coronavirus.report.service.GoogleMobilityDataService;
import com.coronavirus.report.service.SocialDistancingDataService;
import com.coronavirus.report.service.SummaryDataService;

@Controller
public class StateReadinessController {
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
	@Autowired
	GoogleMobilityDataService googleMobilityDataService;
	
	@Autowired
    SummaryDataService summaryDataService;

	@Autowired
	SocialDistancingDataService socialDistancingDataService;
	
	List<MobilityStats> allMobileStats;
	
	@GetMapping("/statereadiness")
	public String startereadiness (Model model) {
		allMobileStats = googleMobilityDataService.getAllStats();

		model.addAttribute("allMobileStats",  allMobileStats);
		
		return "statereadiness";
	}
	
}
