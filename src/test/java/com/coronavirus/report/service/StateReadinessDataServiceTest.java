package com.coronavirus.report.service;

import static org.junit.jupiter.api.Assertions.*;

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
		List<MobilityStats> expected = allMobileStats;
		
		//List<MobilityStats> actual = stateReadinessDataService.getLatestResidentialTrend(allMobileStats, "US", "United States", "Connecticut");
		
		assertEquals(expected, actual, "The expected is not equal to the actual.");
	}

}
