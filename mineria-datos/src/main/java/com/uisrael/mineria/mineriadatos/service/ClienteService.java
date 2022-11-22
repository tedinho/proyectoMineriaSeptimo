package com.uisrael.mineria.mineriadatos.service;

import javax.persistence.EntityManager;

import com.uisrael.mineria.mineriadatos.modelo.Cliente;
import com.uisrael.mineria.mineriadatos.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteService extends GenericService<Cliente, Long> {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public JpaRepository<Cliente, Long> getRepository() {
		return clienteRepository;
	}

}
