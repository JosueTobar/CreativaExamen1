package com.examne.model;

public class Producto {
	private String nombre;
	private String categoria;
	private String proveedor;
	private int cantidad;
	private float precio;
	private float iva;
	private float inpuesto;
	
	
	public Producto() {
	
	}


	public Producto(String nombre, String categoria, String proveedor, int cantidad, float precio, float iva,float inpuesto) {

		this.nombre = nombre;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = precio;
		this.iva = iva;
		this.inpuesto = inpuesto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public float getIva() {
		return iva;
	}


	public void setIva(float iva) {
		this.iva = iva;
	}


	public float getInpuesto() {
		return inpuesto;
	}


	public void setInpuesto(float inpuesto) {
		this.inpuesto = inpuesto;
	}
	
	
	
}
