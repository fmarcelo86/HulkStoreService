package com.todo1.store.jpa;

import org.springframework.data.repository.CrudRepository;

import com.todo1.store.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
