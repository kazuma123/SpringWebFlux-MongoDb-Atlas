package com.wepapp.viajes.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wepapp.viajes.utils.ViajesState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "viaje")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Viaje{

	@Id
	private String id;
	
	private ViajeDate start;

    private ViajeDate end;

    private Country country;

    private City city;

    private Passenger passenger;

    private Driver driver;

    private Car car;

    private ViajesState status;

    private String check_code;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date updatedAt;

    private double price;

    private Location driver_location;
}
