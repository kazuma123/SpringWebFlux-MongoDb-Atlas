package com.wepapp.viajes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViajeDate {

	@JsonProperty("$date")
	private String date;

	@JsonProperty("pickup_address")
    private String pickupAddress;
	
	@JsonProperty("pickup_location")
    private Location pickupLocation;
    
}
