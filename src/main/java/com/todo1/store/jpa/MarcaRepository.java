package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Long> {
}
