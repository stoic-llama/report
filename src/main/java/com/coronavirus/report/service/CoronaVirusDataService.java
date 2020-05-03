package com.coronavirus.report.service;

import com.coronavirus.report.model.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {

    //private static String VIRUS_DATA_URL = "https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private static String VIRUS_DATA_URL = "https://covidtracking.com/api/v1/states/daily.csv";
	
    private List<LocationStats> allStats = new ArrayList<>();

    public List<LocationStats> getAllStats() {
        try {
			fetchVirusData();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
    	return allStats;
    }

	
    
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *") 
	  // cron = seconds, minutes, hours, days, weeks, months. Run every hour. 
	  // match @Scheduled with @EnableScheduling annotation in ReportApplication.java to let it run every hour.     
    private void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) { 
            LocationStats locationStat = new LocationStats();
            locationStat.setDate(record.get("date"));
            locationStat.setState(record.get("state"));
            locationStat.setHospitalizedCurrently(parseInteger(record.get("hospitalizedCurrently"), 0));
            locationStat.setInIcuCurrently(parseInteger(record.get("inIcuCurrently"), 0));
            locationStat.setOnVentilatorCurrently(parseInteger(record.get("onVentilatorCurrently"), 0)); 
            locationStat.setPositive(parseInteger(record.get("positive"), 0));
            locationStat.setPositiveIncrease(parseInteger(record.get("positiveIncrease"), 0));
            newStats.add(locationStat);
           
            /*
             	date
				state
				positive
				negative
				pending
				hospitalizedCurrently
				hospitalizedCumulative
				inIcuCurrently
				inIcuCumulative
				onVentilatorCurrently
				onVentilatorCumulative
				recovered
				hash
				dateChecked
				death
				hospitalized
				total
				totalTestResults
				posNeg
				fips
				deathIncrease
				hospitalizedIncrease
				negativeIncrease
				positiveIncrease
				totalTestResultsIncrease
             */
        }
        this.allStats = newStats;
    }
    
	
    public static int parseInteger( String string, int defaultValue ) {
    	  try {
    	    return Integer.parseInt(string);
    	  }
    	  catch (NumberFormatException e ) {
    	    return defaultValue;
    	  }
    }

}