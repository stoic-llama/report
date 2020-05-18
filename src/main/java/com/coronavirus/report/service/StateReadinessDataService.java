package com.coronavirus.report.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coronavirus.report.model.MobilityStats;

@Service
public class StateReadinessDataService {

	
	public int getLatestResidentialTrend(List<MobilityStats> allMobileStats, String countryCode, String country, String state) {
		List<MobilityStats> newMobileStats = new LinkedList<>();
		
		newMobileStats = filterListByCountryState(allMobileStats, countryCode, country, state);
		
		int daysKeepingSocialDistancing = 0;
		for(int i=newMobileStats.size()-1; i >= newMobileStats.size()-14; i--) {
			if(newMobileStats.get(i).getResidential_percent_change_from_baseline() >= 0) {
				daysKeepingSocialDistancing++;
			};
		}
		
		
		return daysKeepingSocialDistancing;
	}
	
	
	public String getRecommendation(int hospitalized, int daysKeepingSocialDistance, int positivesTrend) {
		String recommendation = "Not sure";
		
		if ( (hospitalized >= 14) && (daysKeepingSocialDistance >= 14) && (positivesTrend >= 80) ) {
			recommendation = "Green Light";
		} else if ((hospitalized >= 0) && (daysKeepingSocialDistance >= 0) && (positivesTrend >= 50) ) {
			recommendation = "Yellow Light - still need to wait";
		} else {
			recommendation = "Red Light = stay home!";
		}
		
		return recommendation;
	}
	
	
	/////////////////////////////////////////HELPER METHODS/////////////////////////////////////////
	
	
	private List<MobilityStats> filterListByCountryState (List<MobilityStats> allMobileStats, String countryCode, String country, String state) {
		List<MobilityStats> filteredMobileStats = new LinkedList<>();
		
		String filter = countryCode+country+state+"No data";  // we are not looking at county level detail now, so exclude sub-region2
		
		int counter = 0;
		String tempCountryCode = "";
		String tempCountry = "";
		String tempState = "";
		String tempCounty = "";
		String temp = "";
		
		boolean exit = false;
		for (MobilityStats m : allMobileStats) {
	
			tempCountryCode = allMobileStats.get(counter).getCountry_region_code();
			tempCountry = allMobileStats.get(counter).getCountry_region(); 
			tempState = allMobileStats.get(counter).getSub_region_1();
			tempCounty = allMobileStats.get(counter).getSub_region_2();
			temp = tempCountryCode + tempCountry + tempState + tempCounty;  
			
			while (filter.equals(temp)) {
				tempCountryCode = allMobileStats.get(counter).getCountry_region_code();
				tempCountry = allMobileStats.get(counter).getCountry_region(); 
				tempState = allMobileStats.get(counter).getSub_region_1();
				tempCounty = allMobileStats.get(counter).getSub_region_2();
				temp = tempCountryCode + tempCountry + tempState + tempCounty;  
				
				filteredMobileStats.add(allMobileStats.get(counter));
				System.out.println(allMobileStats.get(counter).toString());
				
				exit = true;
				counter++;


			}

			if (exit) {
				break;
			}

		} // end for loop
		
		return filteredMobileStats; 
	}
	
}
