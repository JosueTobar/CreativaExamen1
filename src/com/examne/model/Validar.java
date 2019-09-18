package com.examne.model;

import java.awt.List;
import java.util.ArrayList;

public class Validar {
	public static boolean valida_int(String cadena) {
		Integer num;
		try {
			num = Integer.parseInt(cadena);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public static boolean valida_float(String cadena) {
		Float num;
		try {
			num = Float.parseFloat(cadena);
			return true;
		} catch (Exception e) { 
			return false;
		}
	 }
	
	public static boolean valida_categoria(ArrayList<Categoria> listC, String cadena ) {
		for(Categoria c : listC ) {
			if(c.getNombre().equalsIgnoreCase(cadena)) {
				return true;	
			}
		}
		return false;
	 }

	public static boolean valida_proveedor(ArrayList<Proveedor> listP, String cadena ) {
		for(Proveedor p : listP ) {
			if(p.getNombre().equalsIgnoreCase(cadena)) {
				return true;	
			}
		}
		return false;
	 }
	public static boolean valida_inpuesto(String cadena) {
		Integer num;
		try {
			num = Integer.parseInt(cadena);
			if(num > 0 && num <=5) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}
}
