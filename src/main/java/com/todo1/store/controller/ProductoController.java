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

import com.todo1.store.entity.Producto;
import com.todo1.store.jpa.ProductoRepository;

@CrossOrigin
@RestController
public class ProductoController {
	private static final Logger log = LogManager.getLogger(ProductoController.class);
	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/producto")
	public @ResponseBody Iterable<Producto> getProductos() {
		log.info("Request: /getProductos");
		return productoRepository.findAll();
	}

	@GetMapping("/producto/id/{idProducto}")
	public @ResponseBody Producto getProducto(@PathVariable("idProducto") Long idProducto) {
		log.info("Request: /getProducto " + idProducto);
		return productoRepository.findById(idProducto).orElse(new Producto());
	}
	
	@GetMapping("/producto/nombre/{nombreProducto}")
	public @ResponseBody Iterable<Producto> getProductoByNombre(@PathVariable("nombreProducto") String nombreProducto) {
		log.info("Request: /getProductoByNombre " + nombreProducto);
		return productoRepository.findByNombreLike(nombreProducto);
	}

	@PostMapping("/producto")
	public @ResponseBody Producto setProducto(@RequestBody Producto producto) {
		log.info("Request: /setProducto " + producto);
		return productoRepository.save(producto);
	}

	@PutMapping("/producto")
	public @ResponseBody Producto updateProducto(@RequestBody Producto producto) {
		log.info("Request: /updateProducto " + producto);
		return productoRepository.save(producto);
	}

	@DeleteMapping("/producto/id/{idProducto}")
	public @ResponseBody void deleteProducto(@PathVariable("idProducto") Long idProducto) {
		log.info("Request: /deleteProducto " + idProducto);
		productoRepository.deleteById(idProducto);
	}
}