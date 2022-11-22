package com.uisrael.mineria.mineriadatos.service;

import com.uisrael.mineria.mineriadatos.modelo.Servicio;
import com.uisrael.mineria.mineriadatos.repository.ServicioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioService extends GenericService<Servicio, Long> {

	@Autowired
	ServicioRepository servicioRepository;

	@Override
	public JpaRepository<Servicio, Long> getRepository() {
		return servicioRepository;
	}

}
