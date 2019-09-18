package com.examne.model;

public class Categoria {
 private String nombre;

public Categoria() {
	super();
}

public Categoria(String nomnbre) {
	super();
	this.nombre = nomnbre;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nomnbre) {
	this.nombre = nomnbre;
}
 
public static Categoria addSimple(String nombre) {
	Categoria obj = new Categoria();
	obj.setNombre(nombre);
	return obj;
}
 
}
