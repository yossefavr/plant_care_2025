package com.plant_care_2025.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String tripName;

	
	  private String start_destenation; 
	  private String endDestenation;
	 

	public Long getId() {
		return Id;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public String getStart_destenation() {
		return start_destenation;
	}

	public void setStart_destenation(String start_destenation) {
		this.start_destenation = start_destenation;
	}

	public String getEndDestenation() {
		return endDestenation;
	}


	public void setEndDestenation(String endDestenenation) {
		this.endDestenation = endDestenenation;
	}

}
