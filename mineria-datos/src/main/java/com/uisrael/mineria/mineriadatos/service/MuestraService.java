package com.uisrael.mineria.mineriadatos.service;

import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;

import com.uisrael.mineria.mineriadatos.modelo.Muestra;
import com.uisrael.mineria.mineriadatos.repository.MuestraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MuestraService extends GenericService<Muestra, Long> {

	@Autowired
	MuestraRepository muestraRepository;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired
	EntityManager entityManager;

	@Override
	public JpaRepository<Muestra, Long> getRepository() {
		return muestraRepository;
	}

}
