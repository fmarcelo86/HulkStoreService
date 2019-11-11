package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Venta;

public interface VentaRepository extends CrudRepository<Venta, Long> {
}
