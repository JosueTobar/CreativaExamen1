package com.examne.model;

public class Proveedor {
	public String nombre;

	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Proveedor() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//add simple
	public static Proveedor addSimple(String nombre) {
		Proveedor obj = new Proveedor();
		obj.setNombre(nombre);
		return obj;
	} 
}
