package com.todo1.store.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.store.entity.Categoria;
import com.todo1.store.jpa.CategoriaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoriaControllerTest {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Test
	public void testGetCategorias() throws Exception {
		Iterable<Categoria> categorias = categoriaRepository.findAll();
		assertNotNull(categorias);
	}

	@Test
	public void testSaveCategorias() {
		Categoria categoria = new Categoria();
		categoriaRepository.save(categoria);    	
	}
}
