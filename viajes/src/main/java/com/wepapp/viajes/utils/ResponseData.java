package com.wepapp.viajes.utils;
import java.util.List;

import com.wepapp.viajes.models.Viaje;
import lombok.Data;

@Data
public class ResponseData {
	private long count;
    private List<Viaje> elements;
    
    public ResponseData(long count, List<Viaje> elements) {
    	this.count = count;
        this.elements = elements;
        this.count = elements.size();
    }
}
