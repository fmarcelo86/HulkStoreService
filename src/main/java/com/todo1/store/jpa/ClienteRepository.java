package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
