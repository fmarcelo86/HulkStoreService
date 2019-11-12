package com.todo1.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo1.store.entity.Categoria;
import com.todo1.store.entity.Cliente;
import com.todo1.store.entity.Marca;
import com.todo1.store.entity.Producto;
import com.todo1.store.entity.Usuario;
import com.todo1.store.jpa.CategoriaRepository;
import com.todo1.store.jpa.ClienteRepository;
import com.todo1.store.jpa.MarcaRepository;
import com.todo1.store.jpa.ProductoRepository;
import com.todo1.store.jpa.UsuarioRepository;

@SpringBootApplication
public class HulkStoreServiceApplication implements CommandLineRunner {
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
		
		clienteRepository.save(new Cliente("123456", "Cliente anonimo", "123456", "cliente@todo1.com", "Cr 50 # 49 - 34"));
		usuarioRepository.save(new Usuario("123456", "Vendedor1", "123456", "vendedor@todo1.com", "Cll 53 # 56 - 76"));
	}
}
