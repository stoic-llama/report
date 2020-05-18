package com.coronavirus.report.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coronavirus.report.model.MobilityStats;

@Service
public class GoogleMobilityDataService {
	
	private List<MobilityStats> allMobileStats = new LinkedList<>();
	
	// private static String GOOGLE_MOBILITY_DATA_URL = "https://www.gstatic.com/covid19/mobility/Global_Mobility_Report.csv";
	
	String line = "";
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate; 
	
	public void fetchMobilityData() throws IOException {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/files/gstatic_sample.csv"));
			
			int endOfFile = findNumberOfLines();
			int counter = 0;
			String temp = "";
			while ( (line = br.readLine()) != null ) { // parse one line at a time
				String[] data = line.split(",",11);
				
				if (counter != 0 && counter < endOfFile) { // skip first line which is header
					MobilityStats mobilityStats = new MobilityStats();
					
					mobilityStats.setCountry_region_code(checkStringNull(data[0], "No data"));
					mobilityStats.setCountry_region(checkStringNull(data[1], "No data"));
					mobilityStats.setSub_region_1(checkStringNull(data[2], "No data"));
					mobilityStats.setSub_region_2(checkStringNull(data[3], "No data"));
					if (!data[4].isBlank()) { // if there is a valid String for date
						mobilityStats.setDate(LocalDate.parse(data[4], formatter));  //convert String to LocalDate
					}
					mobilityStats.setRetail_and_recreation_percent_change_from_baseline(parseInteger(data[5], 99999));
					mobilityStats.setGrocery_and_pharmacy_percent_change_from_baseline(parseInteger(data[6], 99999));
					mobilityStats.setParks_percent_change_from_baseline(parseInteger(data[7], 99999));
					mobilityStats.setTransit_stations_percent_change_from_baseline(parseInteger(data[8], 99999));
					mobilityStats.setWorkplaces_percent_change_from_baseline(parseInteger(data[9], 99999));
					mobilityStats.setResidential_percent_change_from_baseline(parseInteger(data[10], 99999));
	
					/*# field
					 *
					 *0 country_region_code,
					 *1 country_region,
					 *2 sub_region_1,
					 *3 sub_region_2,
					 *4 date,
					 *5 retail_and_recreation_percent_change_from_baseline,
					 *6 grocery_and_pharmacy_percent_change_from_baseline,
					 *7 parks_percent_change_from_baseline,
					 *8 transit_stations_percent_change_from_baseline,
					 *9 workplaces_percent_change_from_baseline,
					 *10 residential_percent_change_from_baseline
					 */
					
					System.out.println(mobilityStats.toString());
	
					allMobileStats.add(mobilityStats);
				} // end if
				
				counter++;
				
			} // end while loop
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    } // end fetchMobilityData()
    
	private static int findNumberOfLines() throws IOException, FileNotFoundException {
	    String input;
	    int count = 0;  // to avoid array out of bounds, because 0 would count one line too many
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/files/gstatic_sample.csv"));
		
		while((input = bufferedReader.readLine()) != null) {
	    	count++;
		}

		bufferedReader.close();
	    return count;
	}
	
    private static int parseInteger( String string, int defaultValue ) {
    	  try {
    	    return Integer.parseInt(string);
    	  }
    	  catch (NumberFormatException e ) {
    	    return defaultValue;
    	  }
    }
    
    private static String checkStringNull( String str, String defaultValue ) {
    	if (str.isEmpty() || str == null) {
    		str = defaultValue; 
    	}
    	return str;
    }
    
    public List<MobilityStats> getAllStats() {
        try {
			fetchMobilityData();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    	return allMobileStats;
    }
    
}
