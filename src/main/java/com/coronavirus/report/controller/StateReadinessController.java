package com.coronavirus.report.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coronavirus.report.model.LocationStats;
import com.coronavirus.report.model.MobilityStats;
import com.coronavirus.report.service.CoronaVirusDataService;
import com.coronavirus.report.service.GoogleMobilityDataService;
import com.coronavirus.report.service.StateReadinessDataService;
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
	StateReadinessDataService stateReadinessDataService;
	
	@GetMapping("/statereadiness")
	public String startereadiness (Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
		List<MobilityStats> allMobileStats = googleMobilityDataService.getAllStats();
        int hospitalized = -1;
        int daysKeepingSocialDistancing = -1;
        int positives = -1;
        int totalTestResults = -1;
        String recommendation = "Not sure";
        LocalDate date = LocalDate.now();
		
        hospitalized = summaryDataService.getDaysSinceDecline(allStats, "CT");
        
        daysKeepingSocialDistancing = stateReadinessDataService.getLatestResidentialTrend(allMobileStats, "US", "United States", "Connecticut");
        
        positives = allStats.get(allStats.size()-1).getPositive();
        totalTestResults = allStats.get(allStats.size()-1).getTotalTestResults();
        int positivesTrend = (positives/totalTestResults) * 100;

        model.addAttribute("daysHospitalizedDeclining", hospitalized);
		model.addAttribute("daysKeepingSocialDistancing", daysKeepingSocialDistancing);
		model.addAttribute("daysPositivesDeclining", positivesTrend);
		model.addAttribute("Recommendation", stateReadinessDataService.getRecommendation(hospitalized, daysKeepingSocialDistancing, positivesTrend));  // TODO: Need to program recommendation logic
		model.addAttribute("dateToday", date);
		
		return "statereadiness";
	}
	
}
