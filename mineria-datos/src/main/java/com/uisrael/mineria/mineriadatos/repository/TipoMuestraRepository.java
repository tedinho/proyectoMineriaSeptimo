package com.uisrael.mineria.mineriadatos.repository;

import com.uisrael.mineria.mineriadatos.modelo.TipoMuestra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMuestraRepository extends JpaRepository<TipoMuestra, Long> {

}
