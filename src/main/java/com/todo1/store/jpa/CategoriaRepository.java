package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
