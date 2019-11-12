package com.todo1.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo1.store.entity.Categoria;
import com.todo1.store.entity.Marca;
import com.todo1.store.entity.Producto;
import com.todo1.store.jpa.CategoriaRepository;
import com.todo1.store.jpa.MarcaRepository;
import com.todo1.store.jpa.ProductoRepository;

@SpringBootApplication
public class HulkStoreServiceApplication implements CommandLineRunner {
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HulkStoreServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		marcaRepository.save(new Marca("Marvel"));
		marcaRepository.save(new Marca("DC Comics"));		
		categoriaRepository.save(new Categoria("Camisetas"));
		categoriaRepository.save(new Categoria("Vasos"));
		categoriaRepository.save(new Categoria("Comics"));
		categoriaRepository.save(new Categoria("Juguetes"));
		categoriaRepository.save(new Categoria("Accesorios"));
		
		Producto producto = new Producto();
		producto.setMarca(marcaRepository.findById(1L).get());
		producto.setCategoria(categoriaRepository.findById(1L).get());
		producto.setNombre("Camiseta XL Marvel");
		producto.setPrecio(80000D);
		producto.setStock(55L);
		productoRepository.save(producto);
		
		producto = new Producto();
		producto.setMarca(marcaRepository.findById(2L).get());
		producto.setCategoria(categoriaRepository.findById(1L).get());
		producto.setNombre("Camiseta XS DC Comics");
		producto.setPrecio(75000D);
		producto.setStock(68L);
		productoRepository.save(producto);
	}
}
