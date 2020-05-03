package com.coronavirus.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coronavirus.report.model.LocationStats;


@Service
public class SummaryDataService {

	public int getLatestHospitalized(List<LocationStats> allStats, String state) {
		
		return -1;
	}
	
	public int getLatestPositive(List<LocationStats> allStats, String state) {
		return -1;
	}

	public int getDaysSinceDecline(List<LocationStats> allStats, String state) {
		return -1;
	}
    
	public String getVerdict(int daysSinceDecline, String state) {
		
		return "Not sure";
	}
    
}
