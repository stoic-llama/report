package com.coronavirus.report.model;

public class LocationStats {

	private String date;
	private String state;
	private int positive;
	private int negative;
	private int pending;
	private int hospitalizedCurrently;
	private int hospitalizedCumulative;
	private int inIcuCurrently;
	private int inIcuCumulative;
	private int onVentilatorCurrently;
	private int onVentilatorCumulative;
	private int recovered;
	private String hash;
	private String dateChecked;
	private int death;
	private int hospitalized;
	private int totalTestResults;
	private String fips;
	private int deathIncrease;
	private int hospitalizedIncrease;
	private int negativeIncrease;
	private int positiveIncrease;
	private int totalTestResultsIncrease;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPositive() {
		return positive;
	}
	public void setPositive(int positive) {
		this.positive = positive;
	}
	public int getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	public int getHospitalizedCurrently() {
		return hospitalizedCurrently;
	}
	public void setHospitalizedCurrently(int hospitalizedCurrently) {
		this.hospitalizedCurrently = hospitalizedCurrently;
	}
	public int getHospitalizedCumulative() {
		return hospitalizedCumulative;
	}
	public void setHospitalizedCumulative(int hospitalizedCumulative) {
		this.hospitalizedCumulative = hospitalizedCumulative;
	}
	public int getInIcuCurrently() {
		return inIcuCurrently;
	}
	public void setInIcuCurrently(int inIcuCurrently) {
		this.inIcuCurrently = inIcuCurrently;
	}
	public int getInIcuCumulative() {
		return inIcuCumulative;
	}
	public void setInIcuCumulative(int inIcuCumulative) {
		this.inIcuCumulative = inIcuCumulative;
	}
	public int getOnVentilatorCurrently() {
		return onVentilatorCurrently;
	}
	public void setOnVentilatorCurrently(int onVentilatorCurrently) {
		this.onVentilatorCurrently = onVentilatorCurrently;
	}
	public int getOnVentilatorCumulative() {
		return onVentilatorCumulative;
	}
	public void setOnVentilatorCumulative(int onVentilatorCumulative) {
		this.onVentilatorCumulative = onVentilatorCumulative;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getDateChecked() {
		return dateChecked;
	}
	public void setDateChecked(String dateChecked) {
		this.dateChecked = dateChecked;
	}
	public int getDeath() {
		return death;
	}
	public void setDeath(int death) {
		this.death = death;
	}
	public int getHospitalized() {
		return hospitalized;
	}
	public void setHospitalized(int hospitalized) {
		this.hospitalized = hospitalized;
	}
	public int getTotalTestResults() {
		return totalTestResults;
	}
	public void setTotalTestResults(int totalTestResults) {
		this.totalTestResults = totalTestResults;
	}
	public String getFips() {
		return fips;
	}
	public void setFips(String fips) {
		this.fips = fips;
	}
	public int getDeathIncrease() {
		return deathIncrease;
	}
	public void setDeathIncrease(int deathIncrease) {
		this.deathIncrease = deathIncrease;
	}
	public int getHospitalizedIncrease() {
		return hospitalizedIncrease;
	}
	public void setHospitalizedIncrease(int hospitalizedIncrease) {
		this.hospitalizedIncrease = hospitalizedIncrease;
	}
	public int getNegativeIncrease() {
		return negativeIncrease;
	}
	public void setNegativeIncrease(int negativeIncrease) {
		this.negativeIncrease = negativeIncrease;
	}
	public int getPositiveIncrease() {
		return positiveIncrease;
	}
	public void setPositiveIncrease(int positiveIncrease) {
		this.positiveIncrease = positiveIncrease;
	}
	public int getTotalTestResultsIncrease() {
		return totalTestResultsIncrease;
	}
	public void setTotalTestResultsIncrease(int totalTestResultsIncrease) {
		this.totalTestResultsIncrease = totalTestResultsIncrease;
	}
	
	@Override
	public String toString() {
		return "LocationStats [date=" + date + ", state=" + state + ", positive=" + positive + ", negative=" + negative
				+ ", pending=" + pending + ", hospitalizedCurrently=" + hospitalizedCurrently
				+ ", hospitalizedCumulative=" + hospitalizedCumulative + ", inIcuCurrently=" + inIcuCurrently
				+ ", inIcuCumulative=" + inIcuCumulative + ", onVentilatorCurrently=" + onVentilatorCurrently
				+ ", onVentilatorCumulative=" + onVentilatorCumulative + ", recovered=" + recovered + ", hash=" + hash
				+ ", dateChecked=" + dateChecked + ", death=" + death + ", hospitalized=" + hospitalized
				+ ", totalTestResults=" + totalTestResults + ", fips=" + fips + ", deathIncrease=" + deathIncrease
				+ ", hospitalizedIncrease=" + hospitalizedIncrease + ", negativeIncrease=" + negativeIncrease
				+ ", positiveIncrease=" + positiveIncrease + ", totalTestResultsIncrease=" + totalTestResultsIncrease
				+ "]";
	}
    
	
	



}