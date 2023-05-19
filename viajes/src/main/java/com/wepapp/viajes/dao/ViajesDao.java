package com.wepapp.viajes.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wepapp.viajes.models.Viaje;

import reactor.core.publisher.Flux;

public interface ViajesDao extends ReactiveMongoRepository<Viaje, String>{

	Flux<Viaje> findByCityName(String ciudad);
	Flux<Viaje> findByCountryName(String pais);
}
