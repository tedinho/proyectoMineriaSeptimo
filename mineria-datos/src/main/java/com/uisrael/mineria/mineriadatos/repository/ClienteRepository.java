package com.uisrael.mineria.mineriadatos.repository;

import com.uisrael.mineria.mineriadatos.modelo.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
