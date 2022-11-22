package com.uisrael.mineria.mineriadatos.repository;

import com.uisrael.mineria.mineriadatos.modelo.TecnicoArea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoAreaRepository extends JpaRepository<TecnicoArea, Long> {

}
