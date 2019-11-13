package com.todo1.store.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.store.entity.Cliente;
import com.todo1.store.jpa.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteControllerTest {
	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	public void testGetClientes() throws Exception {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		assertNotNull(clientes);
	}

	@Test
	public void testSaveCliente() {
		Cliente clientes = new Cliente();
		clienteRepository.save(clientes);    	
	}
}
