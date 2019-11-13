package com.todo1.store.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "idCliente", nullable = false, updatable = true)
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name = "idUsuario", nullable = false, updatable = true)
	private Usuario usuario;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProductoVenta", nullable = false, updatable = true)
	private List<ProductoVenta> productoVenta;
	private Double valorTotal;
	private Date fechaVenta;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<ProductoVenta> getProductoVenta() {
		return productoVenta;
	}
	public void setProductoVenta(List<ProductoVenta> productoVenta) {
		this.productoVenta = productoVenta;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
}
