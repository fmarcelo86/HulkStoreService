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

import com.todo1.store.entity.Categoria;
import com.todo1.store.jpa.CategoriaRepository;

@CrossOrigin
@RestController
public class CategoriaController {
	private static final Logger log = LogManager.getLogger(CategoriaController.class);
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("/categoria")
	public @ResponseBody Iterable<Categoria> getCategorias() {
		log.info("Request: /getCategorias");
		return categoriaRepository.findAll();
	}

	@GetMapping("/categoria/{idCategoria}")
	public @ResponseBody Categoria getCategoria(@PathVariable("idCategoria") Long idCategoria) {
		log.info("Request: /getCategoria " + idCategoria);
		return categoriaRepository.findById(idCategoria).orElse(new Categoria());
	}

	@PostMapping("/categoria")
	public @ResponseBody Categoria setCategoria(@RequestBody Categoria categoria) {
		log.info("Request: /setCategoria " + categoria);
		return categoriaRepository.save(categoria);
	}

	@PutMapping("/categoria")
	public @ResponseBody Categoria updateCategoria(@RequestBody Categoria categoria) {
		log.info("Request: /updateCategoria " + categoria);
		return categoriaRepository.save(categoria);
	}

	@DeleteMapping("/categoria/{idCategoria}")
	public @ResponseBody void deleteCategoria(@PathVariable("idCategoria") Long idCategoria) {
		log.info("Request: /deleteCategoria " + idCategoria);
		categoriaRepository.deleteById(idCategoria);
	}
}