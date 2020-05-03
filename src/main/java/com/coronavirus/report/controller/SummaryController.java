package com.coronavirus.report.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.coronavirus.report.model.LocationStats;
import com.coronavirus.report.service.CoronaVirusDataService;
import com.coronavirus.report.service.SummaryDataService;

@Controller
public class SummaryController {

	// GOAL: Summary to compare CT/NY/MA to State w/ Highest Positive and Hospitalization Rate
	
	// (1) Snapshot Today For Each State - use dropdown with one template to change between 3 states 
	//     because for now it is three api calls by specific state
	//     https://covidtracking.com/api/v1/states/CT/daily.csv
	//	   https://covidtracking.com/api/v1/states/MA/daily.csv
	//     https://covidtracking.com/api/v1/states/NY/daily.csv
	
			// Connecticut Total Positive Today, Total Hospitalized
			// New York Total Positive Today, Total Hospitalized
			// Massachusetts Total Positive Today, Total Hospitalized

			// State With Highest Positive Today, Highest Total Hospitalized Today

	// (2) Trend of the Hospitalization Rate For Connecticut
			// Days since last decline or plateau 
				// First, Hospitalization Current Count Today - Minus Yesterday's Count.  Do this starting 14 days ago from today.
				// Then,  at the first decline, calculate that day versus today - how many days in between.
	
	@Autowired
    SummaryDataService summaryDataService;
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
	
    @GetMapping("/summary")
    public String report (Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int CTHospitalized = -1;
        int CTPositives = -1;
        int CTDaysSinceDecline = -1;
        String CTVerdict = "Not sure";
        int NYHospitalized = -1;
        int NYPositives = -1;
        int NYDaysSinceDecline = -1;
        String NYVerdict = "Not sure";
        int MAHospitalized = -1;
        int MAPositives = -1;
        int MADaysSinceDecline = -1;
        String MAVerdict = "Not sure";
        LocalDate date = LocalDate.now();

        CTHospitalized = summaryDataService.getLatestHospitalized(allStats, "CT");
        CTPositives = summaryDataService.getLatestPositive(allStats, "CT");
        CTDaysSinceDecline = summaryDataService.getDaysSinceDecline(allStats, "CT");
        CTVerdict = summaryDataService.getVerdict(CTDaysSinceDecline, "CT");
        
        NYHospitalized = summaryDataService.getLatestHospitalized(allStats, "NY");
        NYPositives = summaryDataService.getLatestPositive(allStats, "NY");
        NYDaysSinceDecline = summaryDataService.getDaysSinceDecline(allStats, "NY");
        NYVerdict = summaryDataService.getVerdict(CTDaysSinceDecline, "NY");

        MAHospitalized = summaryDataService.getLatestHospitalized(allStats, "MA");
        MAPositives = summaryDataService.getLatestPositive(allStats, "MA");
        MADaysSinceDecline = summaryDataService.getDaysSinceDecline(allStats, "MA");
        MAVerdict = summaryDataService.getVerdict(CTDaysSinceDecline, "MA");
        
        
        model.addAttribute("locationStats", allStats);
        model.addAttribute("DateToday", date);
        model.addAttribute("CTHospitalized", CTHospitalized);
        model.addAttribute("CTPositives", CTPositives);
        model.addAttribute("CTDaysSinceDecline", CTDaysSinceDecline);
        model.addAttribute("CTVerdict", CTVerdict);
        model.addAttribute("NYHospitalized", NYHospitalized);
        model.addAttribute("NYPositives", NYPositives);
        model.addAttribute("NYDaysSinceDecline", NYDaysSinceDecline);
        model.addAttribute("NYVerdict", NYVerdict);
        model.addAttribute("MAHospitalized", MAHospitalized);
        model.addAttribute("MAPositives", MAPositives);
        model.addAttribute("MADaysSinceDecline", MADaysSinceDecline);
        model.addAttribute("MAVerdict", MAVerdict);
        
        return "summary";
    }
	
	
}
