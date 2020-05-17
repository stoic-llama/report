package com.coronavirus.report.model;

import java.time.LocalDate;

public class MobilityStats {
	
	private String country_region_code;
	private String country_region;
	private String sub_region_1;
	private String sub_region_2;
	private LocalDate date;
	private int retail_and_recreation_percent_change_from_baseline;
	private int grocery_and_pharmacy_percent_change_from_baseline;
	private int parks_percent_change_from_baseline;
	private int transit_stations_percent_change_from_baseline;
	private int workplaces_percent_change_from_baseline;
	private int residential_percent_change_from_baseline;
	 
	public String getCountry_region_code() {
		return country_region_code;
	}
	public void setCountry_region_code(String country_region_code) {
		this.country_region_code = country_region_code;
	}
	public String getCountry_region() {
		return country_region;
	}
	public void setCountry_region(String country_region) {
		this.country_region = country_region;
	}
	public String getSub_region_1() {
		return sub_region_1;
	}
	public void setSub_region_1(String sub_region_1) {
		this.sub_region_1 = sub_region_1;
	}
	public String getSub_region_2() {
		return sub_region_2;
	}
	public void setSub_region_2(String sub_region_2) {
		this.sub_region_2 = sub_region_2;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getRetail_and_recreation_percent_change_from_baseline() {
		return retail_and_recreation_percent_change_from_baseline;
	}
	public void setRetail_and_recreation_percent_change_from_baseline(
			int retail_and_recreation_percent_change_from_baseline) {
		this.retail_and_recreation_percent_change_from_baseline = retail_and_recreation_percent_change_from_baseline;
	}
	public int getGrocery_and_pharmacy_percent_change_from_baseline() {
		return grocery_and_pharmacy_percent_change_from_baseline;
	}
	public void setGrocery_and_pharmacy_percent_change_from_baseline(
			int grocery_and_pharmacy_percent_change_from_baseline) {
		this.grocery_and_pharmacy_percent_change_from_baseline = grocery_and_pharmacy_percent_change_from_baseline;
	}
	public int getParks_percent_change_from_baseline() {
		return parks_percent_change_from_baseline;
	}
	public void setParks_percent_change_from_baseline(int parks_percent_change_from_baseline) {
		this.parks_percent_change_from_baseline = parks_percent_change_from_baseline;
	}
	public int getTransit_stations_percent_change_from_baseline() {
		return transit_stations_percent_change_from_baseline;
	}
	public void setTransit_stations_percent_change_from_baseline(int transit_stations_percent_change_from_baseline) {
		this.transit_stations_percent_change_from_baseline = transit_stations_percent_change_from_baseline;
	}
	public int getWorkplaces_percent_change_from_baseline() {
		return workplaces_percent_change_from_baseline;
	}
	public void setWorkplaces_percent_change_from_baseline(int workplaces_percent_change_from_baseline) {
		this.workplaces_percent_change_from_baseline = workplaces_percent_change_from_baseline;
	}
	public int getResidential_percent_change_from_baseline() {
		return residential_percent_change_from_baseline;
	}
	public void setResidential_percent_change_from_baseline(int residential_percent_change_from_baseline) {
		this.residential_percent_change_from_baseline = residential_percent_change_from_baseline;
	}
	
	
	@Override
	public String toString() {
		return "MobilityStats [country_region_code=" + country_region_code + ", country_region=" + country_region
				+ ", sub_region_1=" + sub_region_1 + ", sub_region_2=" + sub_region_2 + ", date=" + date
				+ ", retail_and_recreation_percent_change_from_baseline="
				+ retail_and_recreation_percent_change_from_baseline
				+ ", grocery_and_pharmacy_percent_change_from_baseline="
				+ grocery_and_pharmacy_percent_change_from_baseline + ", parks_percent_change_from_baseline="
				+ parks_percent_change_from_baseline + ", transit_stations_percent_change_from_baseline="
				+ transit_stations_percent_change_from_baseline + ", workplaces_percent_change_from_baseline="
				+ workplaces_percent_change_from_baseline + ", residential_percent_change_from_baseline="
				+ residential_percent_change_from_baseline + "]";
	}

}
