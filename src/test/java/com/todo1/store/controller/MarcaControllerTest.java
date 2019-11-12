package com.todo1.store.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.store.entity.Marca;
import com.todo1.store.jpa.MarcaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MarcaControllerTest {
	@Autowired
	private MarcaRepository marcaRepository;

	@Test
	public void testGetMarcas() throws Exception {
		Iterable<Marca> marcas = marcaRepository.findAll();
		assertNotNull(marcas);
	}

	@Test
	public void testSaveMarca() {
		Marca marcas = new Marca();
		marcaRepository.save(marcas);    	
	}
}
