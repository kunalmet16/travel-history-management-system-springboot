package com.travelmanagement.models;

import java.util.Date;

public class Country {

	
	private Date startdate;
	private Date enddate;
	private int diffInDays;
	public Country() {
		super();
	}

	public Country(Date startdate, Date enddate,int diffInDays) {
		super();
		
		this.startdate = startdate;
		this.enddate = enddate;
		this.diffInDays=diffInDays;
	}

	

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	

	public int getDiffInDays() {
		return diffInDays;
	}

	public void setDiffInDays(int diffInDays) {
		this.diffInDays = diffInDays;
	}

	@Override
	public String toString() {
		return "Country [startdate=" + startdate + ", enddate=" + enddate + ", diffInDays=" + diffInDays + "]";
	}
	
	
}
