package com.uisrael.mineria.mineriadatos.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, Pk extends Serializable> {

	public abstract JpaRepository<T, Pk> getRepository();

	public List<T> findAll() {
		return getRepository().findAll();
	}

	public T findByPk(Pk id) {
		Optional<T> value = getRepository().findById(id);

		if (value.isPresent()) {
			return value.get();
		}

		return null;
	}

	public void update(T o) {
		getRepository().save(o);
	}

	public void save(T o) {
		getRepository().save(o);
	}

	public void delete(T o) {
		getRepository().delete(o);
	}

}
