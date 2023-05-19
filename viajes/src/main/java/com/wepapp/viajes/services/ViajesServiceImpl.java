package com.wepapp.viajes.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wepapp.viajes.dao.ViajesDao;
import com.wepapp.viajes.models.Viaje;
import com.wepapp.viajes.utils.ViajesState;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ViajesServiceImpl implements ViajesService {

	@Autowired
	private ViajesDao dao;

	@Override
	public Flux<Viaje> cantidadViajesTotales(Pageable page) {
		return dao.findAll().skip(page.getOffset()).take(page.getPageSize());

	}

	@Override
	public Flux<Viaje> cantidadViajesTotalesPorCiudad(String ciudad, Pageable page) {
		return dao.findByCityName(ciudad).skip(page.getOffset()).take(page.getPageSize());
	}

	@Override
	public Flux<Viaje> cantidadViajesTotalesPorPais(String pais, Pageable page) {
		return dao.findByCountryName(pais).skip(page.getOffset()).take(page.getPageSize());
	}

	@Override
	public Flux<Viaje> viajesActuales(Pageable page) {
		ViajesState state = null;
		return dao.findAll().filter(p -> p.getStatus() == state.started).skip(page.getOffset()).take(page.getPageSize());
	}

	@Override
	public Mono<Viaje> save(Viaje viaje) {
		return dao.save(viaje);
	}

	@Override
	public Mono<Viaje> update(Viaje viaje, String id) {
		
		return dao.findById(id).flatMap(p -> {
            if (p.getUpdatedAt() != null) {
                p.setUpdatedAt(new Date());
            }
            p.setStart(viaje.getStart());
            p.setEnd(viaje.getEnd());
            p.setCountry(viaje.getCountry());
            p.setCity(viaje.getCity());
            p.setPassenger(viaje.getPassenger());
            p.setDriver(viaje.getDriver());
            p.setCar(viaje.getCar());
            p.setCheck_code(viaje.getCheck_code());
            p.setPrice(viaje.getPrice());
            p.setDriver_location(viaje.getDriver_location());
            return dao.save(p);
        });
	}

}
