package com.uisrael.mineria.mineriadatos.repository;

import com.uisrael.mineria.mineriadatos.modelo.OrdenTrabajo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {

}
