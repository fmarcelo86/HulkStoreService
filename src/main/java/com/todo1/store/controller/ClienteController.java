package com.todo1.store.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.store.entity.Cliente;
import com.todo1.store.jpa.ClienteRepository;

@CrossOrigin
@RestController
public class ClienteController {
	private static final Logger log = LogManager.getLogger(ClienteController.class);
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/cliente")
	public @ResponseBody Iterable<Cliente> getClientes() {
		log.info("Request: /getClientes");
		return clienteRepository.findAll();
	}

	@GetMapping("/cliente/{idCliente}")
	public @ResponseBody Cliente getCliente(@PathVariable("idCliente") Long idCliente) {
		log.info("Request: /getCliente " + idCliente);
		return clienteRepository.findById(idCliente).orElse(new Cliente());
	}
	
	@GetMapping("/cliente/cedula/{cedula}")
	public @ResponseBody Cliente getClienteByCedula(@PathVariable("cedula") String cedula) {
		log.info("Request: /getClienteByCedula " + cedula);
		return clienteRepository.findByCedula(cedula).orElse(new Cliente());
	}

	@PostMapping("/cliente")
	public @ResponseBody Cliente setCliente(@RequestBody Cliente cliente) {
		log.info("Request: /setCliente " + cliente);
		return clienteRepository.save(cliente);
	}

	@PutMapping("/cliente")
	public @ResponseBody Cliente updateCliente(@RequestBody Cliente cliente) {
		log.info("Request: /updateCliente " + cliente);
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/cliente/{idCliente}")
	public @ResponseBody void deleteCliente(@PathVariable("idCliente") Long idCliente) {
		log.info("Request: /deleteCliente " + idCliente);
		clienteRepository.deleteById(idCliente);
	}
}