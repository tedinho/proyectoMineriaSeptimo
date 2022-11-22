package com.uisrael.mineria.mineriadatos.service;

import com.uisrael.mineria.mineriadatos.modelo.TipoMuestra;
import com.uisrael.mineria.mineriadatos.repository.TipoMuestraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoMuestraService extends GenericService<TipoMuestra, Long> {

	@Autowired
	TipoMuestraRepository tipoMuestraRepository;

	@Override
	public JpaRepository<TipoMuestra, Long> getRepository() {
		return tipoMuestraRepository;
	}

}
