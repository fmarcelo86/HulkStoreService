package com.todo1.store.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.store.entity.Categoria;
import com.todo1.store.entity.Marca;
import com.todo1.store.entity.Producto;
import com.todo1.store.jpa.CategoriaRepository;
import com.todo1.store.jpa.MarcaRepository;
import com.todo1.store.jpa.ProductoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductoControllerTest {
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private MarcaRepository marcaRepository;

	@Test
	public void testGetProductos() throws Exception {
		Iterable<Producto> productos = productoRepository.findAll();
		assertNotNull(productos);
	}

	@Test
	public void testSaveProducto() {
		Categoria categoria = new Categoria();
		categoriaRepository.save(categoria);
		
		Marca marcas = new Marca();
		marcaRepository.save(marcas);
		
		Producto productos = new Producto();
		productos.setCategoria(categoria);
		productos.setMarca(marcas);
		productoRepository.save(productos);    	
	}
}
