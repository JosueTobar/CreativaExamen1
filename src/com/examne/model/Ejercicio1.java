package com.examne.model;

import java.util.ArrayList;

public class Ejercicio1 {

	public static String secuencia() {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		for(int i = 1; i< 45 ; i++) {
			numeros.add((numeros.get(i-1)+numeros.get(i)));
			
		}
		return numeros.get(44).toString();
	}
}
