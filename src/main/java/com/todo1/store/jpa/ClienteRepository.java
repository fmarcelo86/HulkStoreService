package com.todo1.store.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Optional<Cliente> findByCedula(String cedula);
}
