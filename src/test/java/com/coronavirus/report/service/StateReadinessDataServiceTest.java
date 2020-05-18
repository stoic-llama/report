package com.coronavirus.report.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coronavirus.report.model.LocationStats;
import com.coronavirus.report.model.MobilityStats;

class StateReadinessDataServiceTest {

	static GoogleMobilityDataService googleMobilityDataService;
	static StateReadinessDataService stateReadinessDataService;
	static List<MobilityStats> allMobileStats;
    
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		stateReadinessDataService = new StateReadinessDataService();
		allMobileStats = googleMobilityDataService.getAllStats();
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
	void testGetLatestResidentialTrend() {		
		List<MobilityStats> newMobileStats = new LinkedList<>();
		
		newMobileStats = filterListByCountryState(allMobileStats, "US", "United States", "Connecticut");
		
		int expected = 0;
		for(int i=newMobileStats.size()-1; i >= newMobileStats.size()-14; i--) {
			if(newMobileStats.get(i).getResidential_percent_change_from_baseline() >= 0) {
				expected++;
			};
		}
		
		int actual = stateReadinessDataService.getLatestResidentialTrend(allMobileStats, "US", "United States", "Connecticut");
		
		assertEquals(expected, actual, "The expected is not equal to the actual.");
	}

	
	/////////////////////////////////////////HELPER METHODS/////////////////////////////////////////
	
	private List<MobilityStats> filterListByCountryState (List<MobilityStats> allMobileStats, String countryCode, String country, String state) {
		List<MobilityStats> filteredMobileStats = new LinkedList<>();
		
		String filter = countryCode+country+state+"No data";  // we are not looking at county level detail now, so exclude sub-region2
		
		String tempCountryCode = "";
		String tempCountry = "";
		String tempState = "";
		String tempCounty = "";
		String temp = "";
		
		for (MobilityStats m : allMobileStats) {
			tempCountryCode = m.getCountry_region_code();
			tempCountry = m.getCountry_region(); 
			tempState = m.getSub_region_1();
			tempCounty = m.getSub_region_2();
			temp = tempCountryCode + tempCountry + tempState + tempCounty;  
			
			if (filter.equals(temp)) {
				filteredMobileStats.add(m);
				System.out.println(m.toString());
			}
		} // end for loop
		
		return filteredMobileStats; 
	}
	
	
	
}
