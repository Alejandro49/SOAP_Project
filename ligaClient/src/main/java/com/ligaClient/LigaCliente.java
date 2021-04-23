package com.ligaClient;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.client.generated.Equipo;
import com.client.generated.Liga;

public class LigaCliente {
	
	private Liga liga;
	
	public LigaCliente (Liga liga) {
		this.liga = liga;
	}
	
	public void mostrarLiga() {
		for (Equipo equipo: liga.getEquipo()) {
			EquipoCliente vistaEq = new EquipoCliente(equipo);
			System.out.println(vistaEq);
			esperar(2);
		}
	}
	
	public void leerEquipoDeTeclado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos del nuevo equipo:");
		System.out.println("Introduce nombre del equipo:");
		String nombre =  sc.nextLine();
		System.out.println("Introduce nombre del pais:");
		String pais =  sc.nextLine();
		int titulos = leerTitulosDeTeclado();
		System.out.println("Introduce nombre del entrenador del equipo:");
		String entrenador =  sc.nextLine();
		System.out.println("Introduce nombre del presidente del equipo:");
		String presidente =  sc.nextLine();
		EquipoCliente equipoCreado = new EquipoCliente(nombre,pais,titulos,entrenador,presidente);
		System.out.println("Equipo que acabas de crear:");
		System.out.println(equipoCreado);
		esperar(3);
		System.out.println("Escriba \"ok\" para añadirlo a la liga");
		String confirmacion = sc.nextLine();
		if (confirmacion.equals("ok")) {
			this.liga.getEquipo().add(equipoCreado.getEquipo());
			System.out.println("Equipo añadido a la liga");
			esperar(2);
		} else {
			System.out.println("No se ha añadido a la liga");
			esperar(2);
		}
	}
	
	private int leerTitulosDeTeclado() {
		
		int titulos = -1;
		Scanner lectorTitulos;
		do {
			try {
				lectorTitulos = new Scanner(System.in);
				System.out.println("Introduce el nº de títulos del equipo: ");
				titulos = lectorTitulos.nextInt();
			} catch (InputMismatchException ime){
				System.out.println("Debes introducir un numero entero, no veas lo que cuesta gestionar excepciones...");
				esperar(2);
			}
			
		} while (titulos<0);
		
		return titulos;
	}


	public Equipo getEquipo(Equipo eq) {
		int index = liga.indexOf(eq);
		if (index == -1) {
			return null;
		} else {
			return liga.get(index);
		}
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   

}
