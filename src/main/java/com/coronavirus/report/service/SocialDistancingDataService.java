package com.coronavirus.report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coronavirus.report.model.MobilityStats;

@Service
public class SocialDistancingDataService {

	// US,United States,Connecticut,Fairfield County,2020-02-15,-1,-5,14,7,-1,0
	
	public List<MobilityStats> getLatestGroceryTrend(List<MobilityStats> allMobileStats, String state) {
		List<MobilityStats> newMobileStats = allMobileStats;
		return newMobileStats;
	}
	
	public List<MobilityStats> getLatestResidentialTrend(List<MobilityStats> allMobileStats, String state) {
		List<MobilityStats> newMobileStats = allMobileStats;
		return newMobileStats;
	}

	
	
}
