package com.todo1.store.controller;

import java.util.Date;

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

import com.todo1.store.entity.Venta;
import com.todo1.store.jpa.ClienteRepository;
import com.todo1.store.jpa.UsuarioRepository;
import com.todo1.store.jpa.VentaRepository;

@CrossOrigin
@RestController
public class VentaController {
	private static final Logger log = LogManager.getLogger(VentaController.class);
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/venta")
	public @ResponseBody Iterable<Venta> getVentas() {
		log.info("Request: /getVentas");
		return ventaRepository.findAll();
	}

	@GetMapping("/venta/{idVenta}")
	public @ResponseBody Venta getVenta(@PathVariable("idVenta") Long idVenta) {
		log.info("Request: /getVenta " + idVenta);
		return ventaRepository.findById(idVenta).orElse(new Venta());
	}

	@PostMapping("/venta")
	public @ResponseBody Venta setVenta(@RequestBody Venta venta) {
		log.info("Request: /setVenta " + venta);
		venta.setCliente(clienteRepository.findById(1L).get());
		venta.setUsuario(usuarioRepository.findById(1L).get());
		venta.setFechaVenta(new Date());
		return ventaRepository.save(venta);
	}

	@PutMapping("/venta")
	public @ResponseBody Venta updateVenta(@RequestBody Venta venta) {
		log.info("Request: /updateVenta " + venta);
		return ventaRepository.save(venta);
	}

	@DeleteMapping("/venta/{idVenta}")
	public @ResponseBody void deleteVenta(@PathVariable("idVenta") Long idVenta) {
		log.info("Request: /deleteVenta " + idVenta);
		ventaRepository.deleteById(idVenta);
	}
}