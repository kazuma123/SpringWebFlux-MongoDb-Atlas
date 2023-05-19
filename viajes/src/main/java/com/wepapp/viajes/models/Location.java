package com.wepapp.viajes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	@JsonProperty("type")
	private String type;
	@JsonProperty("coordinates")
    private double[] coordinates;
}
