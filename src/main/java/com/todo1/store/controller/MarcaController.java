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

import com.todo1.store.entity.Marca;
import com.todo1.store.jpa.MarcaRepository;

@CrossOrigin
@RestController
public class MarcaController {
	private static final Logger log = LogManager.getLogger(MarcaController.class);
	@Autowired
	private MarcaRepository marcaRepository;

	@GetMapping("/marca")
	public @ResponseBody Iterable<Marca> getMarcas() {
		log.info("Request: /getMarcas");
		return marcaRepository.findAll();
	}

	@GetMapping("/marca/{idMarca}")
	public @ResponseBody Marca getMarca(@PathVariable("idMarca") Long idMarca) {
		log.info("Request: /getMarca " + idMarca);
		return marcaRepository.findById(idMarca).orElse(new Marca());
	}

	@PostMapping("/marca")
	public @ResponseBody Marca setMarca(@RequestBody Marca marca) {
		log.info("Request: /setMarca " + marca);
		return marcaRepository.save(marca);
	}

	@PutMapping("/marca")
	public @ResponseBody Marca updateMarca(@RequestBody Marca marca) {
		log.info("Request: /updateMarca " + marca);
		return marcaRepository.save(marca);
	}

	@DeleteMapping("/marca/{idMarca}")
	public @ResponseBody void deleteMarca(@PathVariable("idMarca") Long idMarca) {
		log.info("Request: /deleteMarca " + idMarca);
		marcaRepository.deleteById(idMarca);
	}
}