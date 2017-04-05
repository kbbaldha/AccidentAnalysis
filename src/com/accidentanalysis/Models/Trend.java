package com.accidentanalysis.Models;

public class Trend {

	public int Year;
	public int noOfAccidents;
	public int month;
	
	public Trend(int y,int noofAcc){
		this.Year = y;
		this.noOfAccidents = noofAcc;
	}
	public Trend(){
		this.Year = 0;
		this.noOfAccidents = 0;
		this.month = 0;
	}
}
