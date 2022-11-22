package com.uisrael.mineria.mineriadatos.repository;

import com.uisrael.mineria.mineriadatos.modelo.MuestraOrdenTrabajo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuestraOrdenTrabajoRepository extends JpaRepository<MuestraOrdenTrabajo, Long> {

}
