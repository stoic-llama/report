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

class SocialDistancingDataServiceTest {

	static GoogleMobilityDataService googleMobilityDataService;
	static SocialDistancingDataService socialDistancingDataService;
	static List<MobilityStats> allMobileStats;
    
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		socialDistancingDataService = new SocialDistancingDataService();
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
	void testGetLatestGroceryTrend() {
		List<MobilityStats> expected = allMobileStats;
		
		List<MobilityStats> actual = socialDistancingDataService.getLatestGroceryTrend(allMobileStats, "CT");
		
		assertEquals(expected, actual, "The expected is not equal to the actual.");
	}

	@Test
	void testGetLatestResidentialTrend() {
		List<MobilityStats> expected = allMobileStats;
		
		List<MobilityStats> actual = socialDistancingDataService.getLatestGroceryTrend(allMobileStats, "CT");
		
		assertEquals(expected, actual, "The expected is not equal to the actual.");
	}

}
