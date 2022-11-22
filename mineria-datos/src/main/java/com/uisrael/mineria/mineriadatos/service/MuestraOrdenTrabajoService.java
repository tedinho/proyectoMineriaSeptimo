package com.uisrael.mineria.mineriadatos.service;

import com.uisrael.mineria.mineriadatos.modelo.MuestraOrdenTrabajo;
import com.uisrael.mineria.mineriadatos.repository.MuestraOrdenTrabajoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MuestraOrdenTrabajoService extends GenericService<MuestraOrdenTrabajo, Long> {

	@Autowired
	MuestraOrdenTrabajoRepository muestraOrdenTrabajoRepository;

	@Override
	public JpaRepository<MuestraOrdenTrabajo, Long> getRepository() {
		return muestraOrdenTrabajoRepository;
	}

}
