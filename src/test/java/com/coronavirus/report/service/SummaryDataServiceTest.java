package com.coronavirus.report.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coronavirus.report.model.LocationStats;


class SummaryDataServiceTest {

	static CoronaVirusDataService coronaVirusDataService;
	static SummaryDataService summaryDataService;
    static List<LocationStats> allStats;
    static List<LocationStats> stateStats;

    
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		summaryDataService = new SummaryDataService();
		coronaVirusDataService = new CoronaVirusDataService();
		allStats = coronaVirusDataService.getAllStats();
		stateStats = new ArrayList<>();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetLatestHospitalized() {		
	    int expected = 0;
		int actual = 0;
		
		for (int i=0; i<=allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals("CT")) {
				expected = allStats.get(i).getHospitalizedCurrently();
				i = allStats.size();
			}
		}
		
		actual = summaryDataService.getLatestHospitalized(allStats, "CT");
		
		assertEquals(expected, actual, "Hospitalized count is incorrect.");
	}

	@Test
	void testGetLatestPositive() {
	    int expected = 0;
		int actual = 0;
		
		for (int i=0; i<=allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals("CT")) {
				expected = allStats.get(i).getPositive();
				i = allStats.size();
			}
		}
		
		actual = summaryDataService.getLatestPositive(allStats, "CT");
		
		assertEquals(expected, actual, "Total positive count is incorrect.");
	}

	@Test
	void testGetDaysSinceDecline() {
	    int expected = 0;
		int actual = 0;
		
		int today = 0;
		int yesterday = 0;
		int difference = 0;
		int daysSinceDecline = 0;
		
		for (int i=0; i<=allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals("NY")) {
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
				daysSinceDecline++; // else increment the number of days that the hospitalization count has declined
			}
		}
		
		expected = daysSinceDecline;
		
		actual = summaryDataService.getDaysSinceDecline(allStats, "NY");
		
		assertEquals(expected, actual, "Total days since the last decline is incorrect.");
	}
	
	
	@Test
	void testGetVerdict() {  // TODO: Refactor daysSinceDecline to its own method shared among tests
		String expected = "Not valid";
		String actual = "Not valid";
		int today = 0;
		int yesterday = 0;
		int difference = 0;
		int daysSinceDecline = 0;
		
		for (int i=0; i<=allStats.size()-1; i++) {
			if(allStats.get(i).getState().equals("NY")) {
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
				daysSinceDecline++; // else increment the number of days that the hospitalization count has declined
			}
		}
		
		if(daysSinceDecline >= 14) {
			expected = "Yes";
		} else {
			expected = "No";
		}
		
		actual = summaryDataService.getVerdict(daysSinceDecline);
		
		assertEquals(expected, actual, "The verdict is incorrect.");
	}

}
