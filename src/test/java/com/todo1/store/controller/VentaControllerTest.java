package com.todo1.store.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.store.entity.Categoria;
import com.todo1.store.entity.Cliente;
import com.todo1.store.entity.Marca;
import com.todo1.store.entity.Producto;
import com.todo1.store.entity.ProductoVenta;
import com.todo1.store.entity.Usuario;
import com.todo1.store.entity.Venta;
import com.todo1.store.jpa.CategoriaRepository;
import com.todo1.store.jpa.ClienteRepository;
import com.todo1.store.jpa.MarcaRepository;
import com.todo1.store.jpa.ProductoRepository;
import com.todo1.store.jpa.UsuarioRepository;
import com.todo1.store.jpa.VentaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VentaControllerTest {
	@Autowired
	private VentaRepository ventaRepository;
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

	@Test
	public void testGetVentas() throws Exception {
		Iterable<Venta> marcas = ventaRepository.findAll();
		assertNotNull(marcas);
	}
	
	@Test
	public void testSaveVenta() {
		Venta venta = new Venta();
		marcaRepository.save(new Marca("Marvel"));
		marcaRepository.save(new Marca("DC Comics"));		
		categoriaRepository.save(new Categoria("Camisetas"));
		
		Producto producto = new Producto();
		producto.setMarca(marcaRepository.findById(1L).get());
		producto.setCategoria(categoriaRepository.findById(1L).get());
		producto.setNombre("Camiseta XL Marvel");
		producto.setPrecio(80000D);
		producto.setStock(55L);
		producto = productoRepository.save(producto);
		
		ProductoVenta productoVenta = new ProductoVenta();
		productoVenta.setCantidad(1);
		productoVenta.setProducto(producto);
		
		clienteRepository.save(new Cliente("123456", "Cliente anonimo", "123456", "cliente@todo1.com", "Cr 50 # 49 - 34"));
		usuarioRepository.save(new Usuario("123456", "Vendedor1", "123456", "vendedor@todo1.com", "Cll 53 # 56 - 76"));
		
		venta.setCliente(clienteRepository.findById(1L).get());
		venta.setUsuario(usuarioRepository.findById(1L).get());
		venta.setValorTotal(80000D);
		venta = ventaRepository.save(venta);
		assertNotNull(venta);
	}
}
