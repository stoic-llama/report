package com.coronavirus.report.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
    
	
    
}
