package com.coronavirus.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coronavirus.report.model.LocationStats;


@Service
public class SummaryDataService {
	
	public int getLatestHospitalized(List<LocationStats> allStats, String state) {
		for (int i = 0; i <= allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals(state)) {
				return allStats.get(i).getHospitalizedCurrently();
			}
		}
		
		return -1; // Did not find statistics for this state
	}
	
	
	public int getLatestPositive(List<LocationStats> allStats, String state) {
		for (int i = 0; i <= allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals(state)) {
				return allStats.get(i).getPositive();
			}
		}
		
		return -1; // Did not find statistics for this state
	}

	public int getDaysSinceDecline(List<LocationStats> allStats, String state) {		
		int today = 0;
		int yesterday = 0;
		int difference = 0;
		int daysSinceDecline = 0;
		List<LocationStats> stateStats = new ArrayList<>();
		
		for (int i = 0; i <= allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals(state)) {
				stateStats.add(allStats.get(i));
			}
		}
		
		for (int j = 0; j <= stateStats.size()-1; j++) {
			today = stateStats.get(j).getHospitalizedCurrently();
			yesterday = stateStats.get(j+1).getHospitalizedCurrently();
			difference = today - yesterday;
			
			if(difference > 0) { // if today is greater than yesterday					
				j = stateStats.size(); // then exit the for loop 
			} else {
				daysSinceDecline++; // else increment the days that the hospitalization count has declined
			}
		}
	
		return daysSinceDecline; 
	}
    
	
	public String getVerdict(int daysSinceDecline) {
		String verdict = "Not valid";
		
		if(daysSinceDecline >= 14) {
			verdict = "Yes";
		} else {
			verdict = "No";
		}
		
		return verdict;
	}
    
}
