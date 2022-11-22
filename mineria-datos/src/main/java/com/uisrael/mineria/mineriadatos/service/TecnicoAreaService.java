package com.uisrael.mineria.mineriadatos.service;

import com.uisrael.mineria.mineriadatos.modelo.TecnicoArea;
import com.uisrael.mineria.mineriadatos.repository.TecnicoAreaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TecnicoAreaService extends GenericService<TecnicoArea, Long> {

	@Autowired
	TecnicoAreaRepository tecnicoRepository;

	@Override
	public JpaRepository<TecnicoArea, Long> getRepository() {
		return tecnicoRepository;
	}

}
