package com.examen.views;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.swing.text.AbstractDocument.BranchElement;

import com.examne.model.Categoria;
import com.examne.model.Ejercicio1;
import com.examne.model.Producto;
import com.examne.model.Proveedor;
import com.examne.model.Validar;

public class menu {
	
	
	public static void main(String[] args) {
		 ArrayList<Producto>  listProducto = new ArrayList<>();
		 ArrayList<Proveedor> listProveedores = new ArrayList<>();
		 ArrayList<Categoria> listCategoria = new ArrayList<>();
		 String cadena = "";

			//agregando proveedores por defecto 
			listProveedores.add(Proveedor.addSimple("Disasa SA.DE SV"));
			listProveedores.add(Proveedor.addSimple("SIMAN"));
			listProveedores.add(Proveedor.addSimple("Distribuidora perez"));
			
			//agregando  categorias por defecto 
			listCategoria.add(Categoria.addSimple("Electrodomesticos"));
			listCategoria.add(Categoria.addSimple("Telefonos"));
			listCategoria.add(Categoria.addSimple("Computadoras"));
			listCategoria.add(Categoria.addSimple("Zapatos"));
			listCategoria.add(Categoria.addSimple("Ropa"));
			
			
		Scanner leer = new Scanner(System.in);
		Integer menu = 0,
				subMenu = 0, 
				subsubMenu = 0,
				subsubsubMenu = 0 ;
		
		
		do {
		System.out.println("------------ MENU PRINCIPA -------------------");
		System.out.println("•Ejercicio 1              ------------------:1");
		System.out.println("•Ejercicio 2              ------------------:2");
		System.out.println("•Salir                    ------------------:9");
		System.out.print("•Elija una opción                  ---------:");
		cadena = leer.nextLine();
		System.out.println("----------------------------------------------");
		
		if(Validar.valida_int(cadena)) {
			menu = Integer.parseInt(cadena);
			switch (menu) {
			case 1:
				
				System.out.println("                  EJERCICIO 1                 ");
				System.out.println("----------------------------------------------");
			    System.out.println("Valor 45" + Ejercicio1.secuencia());
				System.out.println("----------------------------------------------");
				break;

			case 2:
				do {
				
				System.out.println("                  EJERCICIO 2                 ");
				System.out.println("----------------------------------------------");
				System.out.println("------------------- MENU  --------------------");
				System.out.println("•Listado de proveedores              -------:1");
				System.out.println("•Listado de categorías               -------:2");
				System.out.println("•Agregar productos                   -------:3");
				System.out.println("•Agregar categorias                  -------:4");
				System.out.println("•Mostrar productos por categoría     -------:5");
				System.out.println("•Productos en un rango de precios    -------:6"); 
				System.out.println("•Mostrar todos los productos         -------:7"); 
				System.out.println("•Salir                               -------:9");
				System.out.print("•Elija una opción                  ---------:");
				cadena = leer.nextLine();
				System.out.println("----------------------------------------------");
				if(Validar.valida_int(cadena)) {
					subMenu = Integer.parseInt(cadena);
					switch (subMenu) {
					case 1:
						listarProveedores(listProveedores);
						break;
					case 2:
						listarCategorias(listCategoria);
						break;
					case 3:
						listProducto.add(addProducto(listCategoria, listProveedores, cadena, leer));
						break;
					case 4:
						
						System.out.println("               Agregar Categorias            ");
						System.out.println("----------------------------------------------");
						System.out.print("Ingrese el nombre nueva categoria: "); 
						listCategoria.add(Categoria.addSimple(leer.nextLine()));
						
						break;
					case 5:
						System.out.println("         productos por  Categorias            ");
						System.out.println("----------------------------------------------");
						listarCategorias(listCategoria);
						System.out.print("Ingrese el nombre nueva categoria: "); 
						cadena = leer.nextLine();
						while(!Validar.valida_categoria(listCategoria, cadena)) {
							System.err.println("categoria no encontrada");
							System.out.print("•Ingrese categoria                   --------:");
							cadena = leer.nextLine();
						}
						for(Producto p :listProducto) {
							if(p.getCategoria().equalsIgnoreCase(cadena)) {
								System.out.println("----------------------------------------------");
								System.out.println("nombre                ------------:"+p.getNombre());
								System.out.println("proveedor             ------------:"+p.getProveedor());
								System.out.println("categoria             ------------:"+p.getCategoria());
								System.out.println("precio neto           ------------:"+p.getPrecio());
								System.out.println("Impuesto agregadi     ------------:%"+p.getInpuesto());
								System.out.println("Impuesto              ------------:"+(p.getPrecio()*(p.getInpuesto()/100) ));
								System.out.println("Iva                   ------------:"+(p.getPrecio()*0.13));
								System.out.println("total                 ------------:"+(p.getPrecio()+(p.getPrecio() *(p.getInpuesto()/100) )+(p.getPrecio()*0.13)));
							}
							
						}
						
						break;
					case 6:
						String ini = "", fin= ""; 
						System.out.println("         productos por  rango                 ");
						System.out.println("----------------------------------------------");
						System.out.print("Cantidad inicial                             :");
						
						
						ini = leer.nextLine();
						while (!Validar.valida_float(ini)) {
							System.err.println("error la precio tiene que ser un numero valido Ejemplo (50.25 o 100)");
							System.out.print("Cantidad inicial                             :");
							ini = leer.nextLine();
						}
						System.out.print("Cantidad Finnal                              :");
						fin = leer.nextLine();
						while (!Validar.valida_float(fin)) {
							System.err.println("error la precio tiene que ser un numero valido Ejemplo (50.25 o 100)");
							System.out.print("Cantidad inicial                             :");
							fin = leer.nextLine();
						}
						
						System.out.println("                  lista productos            ");
						System.out.println("----------------------------------------------");
						for(Producto p :listProducto) {
							if(p.getPrecio() >= Float.parseFloat(ini) && p.getPrecio() <= Float.parseFloat(fin)) {
								System.out.println("           Rango de["+ini+"] a ["+fin+"]");
								System.out.println("----------------------------------------------");
								System.out.println("nombre                ------------:"+p.getNombre());
								System.out.println("proveedor             ------------:"+p.getProveedor());
								System.out.println("categoria             ------------:"+p.getCategoria());
								System.out.println("precio neto           ------------:"+p.getPrecio());
								System.out.println("Impuesto agregadi     ------------:%"+p.getInpuesto());
								System.out.println("Impuesto              ------------:"+(p.getPrecio()*(p.getInpuesto()/100) ));
								System.out.println("Iva                   ------------:"+(p.getPrecio()*0.13));
								System.out.println("total                 ------------:"+(p.getPrecio()+(p.getPrecio() *(p.getInpuesto()/100) )+(p.getPrecio()*0.13)));
								
								System.out.println("----------------------------------------------");
							}
							
						}
						
						
						break;
					case 7:
						System.out.println("                Lista Procutos");
						System.out.println("----------------------------------------------");
						for(Producto p :listProducto) {
							System.out.println("----------------------------------------------");
							System.out.println("nombre                ------------:"+p.getNombre());
							System.out.println("proveedor             ------------:"+p.getProveedor());
							System.out.println("categoria             ------------:"+p.getCategoria());
							System.out.println("precio neto           ------------:"+p.getPrecio());
							System.out.println("Impuesto agregadi     ------------:%"+p.getInpuesto());
							System.out.println("Impuesto              ------------:"+(p.getPrecio()*(p.getInpuesto()/100) ));
							System.out.println("Iva                   ------------:"+(p.getPrecio()*0.13));
							System.out.println("total                 ------------:"+(p.getPrecio()+(p.getPrecio() *(p.getInpuesto()/100) )+(p.getPrecio()*0.13)));
								
								System.out.println("----------------------------------------------");
						}
						break;
					default:
						System.err.println("opción exciste");
						break;
					}
					
				}else{
					System.err.println("Ingrese una opción valida (numero entero)");
				}
				}while (subMenu !=9);
				
			    
				break;
			default:
				System.err.println("opción exciste");
				break;
			}
			
		}else {
			System.err.println("Ingrese una opción valida (numero entero)");
		}
			
		
		}while(menu !=9 );
	}
	
	public static void listarCategorias(ArrayList<Categoria> lista) {
		System.out.println("                  lita Categorias            ");
		System.out.println("----------------------------------------------");
		for(Categoria c : lista ) {
			System.out.println("nombre  categoria: "+c.getNombre());
		}
	}
	
	public static void listarProveedores(ArrayList<Proveedor> listap) {
		
		System.out.println("                  lita proveedores            ");
		System.out.println("----------------------------------------------");
		for(Proveedor p : listap ) {
			System.out.println("nombre  porveedor : "+p.getNombre());
		}
	}

	
	public static Producto addProducto(ArrayList<Categoria> listCategoria, ArrayList<Proveedor> listProveedores,String cadena, Scanner leer) {
		
		Producto pro = new Producto(); 
		System.out.println("               Agregar Producto               ");
		System.out.println("----------------------------------------------");
		System.out.print("•Ingrese nombre                      --------:");
		pro.setNombre(leer.nextLine());
		System.out.print("•Ingrese categoria                   --------:");
		cadena = leer.nextLine();
		while(!Validar.valida_categoria(listCategoria, cadena)) {
			System.err.println("categoria no encontrada");
			System.out.print("•Ingrese categoria                   --------:");
			cadena = leer.nextLine();
		}
		pro.setCategoria(cadena);
		
		System.out.print("•Ingrese proveedor                   --------:");
		cadena = leer.nextLine();
		while(!Validar.valida_proveedor(listProveedores, cadena)) {
			System.err.println("proveedor no encontrado");
			System.out.print("•Ingrese proveedor                   --------:");
			cadena = leer.nextLine();
		}
		
		pro.setProveedor(cadena);
		System.out.print("•Ingrese cantidad                    --------:");
		cadena = leer.nextLine();
		while(!Validar.valida_int(cadena)) {
			System.err.println("error la cantidad tiene que ser un numero entero");
			System.out.print("•Ingrese cantidad                    --------:");
			cadena = leer.nextLine();
		}
		pro.setCantidad(Integer.parseInt(cadena));
	
		System.out.print("•Ingrese precio                      --------:");
		cadena = leer.nextLine();
		while (!Validar.valida_float(cadena)) {
			System.err.println("error la precio tiene que ser un numero valido Ejemplo (50.25 o 100)");
			System.out.print("•Ingrese precio                      --------:");
			cadena = leer.nextLine();
		}
		pro.setPrecio(Float.parseFloat(cadena));
		
		if(pro.getPrecio()>= 75) {
			System.out.println("Tienees impuesto  Agregado :C");
			System.out.print("•porcentaje de inpuesto agrado (1 a 5)   ----:");
			cadena = leer.nextLine();
			while (!Validar.valida_inpuesto(cadena)) {
				System.err.println("error la precio tiene que ser un numero entero y estar en el rango (1 a 5)");
				System.out.print("•porcentaje de inpuesto agrado (1 a 5)   ----:");
				cadena = leer.nextLine();
			 }
			pro.setInpuesto(Float.parseFloat(cadena));
		}
		
		return pro;
	}
}
