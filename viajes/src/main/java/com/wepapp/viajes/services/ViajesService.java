package com.wepapp.viajes.services;

import org.springframework.data.domain.Pageable;

import com.wepapp.viajes.models.Viaje;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ViajesService {

	Flux<Viaje> cantidadViajesTotales(Pageable page);
	
	Flux<Viaje> cantidadViajesTotalesPorCiudad(String ciudad, Pageable page);
	
	Flux<Viaje> cantidadViajesTotalesPorPais(String pais, Pageable page);
	
	Flux<Viaje> viajesActuales(Pageable page);
	
	Mono<Viaje> save(Viaje viaje);
	
	Mono<Viaje> update(Viaje viaje, String id);
}
