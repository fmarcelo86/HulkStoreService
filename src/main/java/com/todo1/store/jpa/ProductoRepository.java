package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
