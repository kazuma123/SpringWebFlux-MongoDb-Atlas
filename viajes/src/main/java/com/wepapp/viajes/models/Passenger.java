package com.wepapp.viajes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Passenger {
	@JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;
}
