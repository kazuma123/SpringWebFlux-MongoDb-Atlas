package com.wepapp.viajes.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wepapp.viajes.models.Viaje;
import com.wepapp.viajes.services.ViajesService;
import com.wepapp.viajes.utils.ResponseData;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/viajes")
public class ViajesController {

	@Autowired
	private ViajesService service;

	@GetMapping("/cantidadViajesTotales/page/{page}")
	public Flux<Viaje> cantidadViajesTotales(@PathVariable int page) {
		Pageable pageable = PageRequest.of(page, 10);
		return service.cantidadViajesTotales(pageable);

	}

	@GetMapping("/cantidadViajesTotalesPorCiudad/{ciudad}/page/{page}")
	public Mono<Object> cantidadViajesTotalesPorCiudad(@PathVariable int page, @PathVariable String ciudad) {
		Pageable pageable = PageRequest.of(page, 10);
		Flux<Viaje> viaje = service.cantidadViajesTotalesPorCiudad(ciudad, pageable);
		Mono<Long> countMono = viaje.count();
		return countMono.flatMap(count -> viaje.collectList().map(elements -> new ResponseData(count, elements)))
				.map(responseData -> ResponseEntity.ok().body(responseData));

	}

	@GetMapping("/cantidadViajesTotalesPorPais/{pais}/page/{page}")
	public Mono<Object> cantidadViajesTotalesPorPais(@PathVariable int page, @PathVariable String pais) {
		Pageable pageable = PageRequest.of(page, 10);
		Flux<Viaje> viaje = service.cantidadViajesTotalesPorPais(pais, pageable);
		Mono<Long> countMono = viaje.count();
		return countMono.flatMap(count -> viaje.collectList().map(elements -> new ResponseData(count, elements)))
				.map(responseData -> ResponseEntity.ok().body(responseData));

	}

	@GetMapping("/viajesActuales/page/{page}")
	public Mono<Object> viajesActuales(@PathVariable int page) {
		Pageable pageable = PageRequest.of(page, 10);
		Flux<Viaje> viaje = service.cantidadViajesTotales(pageable);
		Mono<Long> countMono = viaje.count();
		return countMono.flatMap(count -> viaje.collectList().map(elements -> new ResponseData(count, elements)))
				.map(responseData -> ResponseEntity.ok().body(responseData));

	}
	
	@PostMapping
	public Mono<Viaje> save(@RequestBody Viaje viaje){
		return service.save(viaje);
	}
	
	
	@PutMapping("/{id}")
	public Mono<Viaje> update(@RequestBody Viaje viaje, @PathVariable String id){
		return service.update(viaje, id);
	}
	
	
	
	
	
	
}
