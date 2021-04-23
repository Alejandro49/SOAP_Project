package modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.client.generated.Equipo;

public class EquipoDao {
	
	private Equipo equipo;
	
	public EquipoDao (Equipo eq) {
		this.equipo = eq;
	}
	
	
	public EquipoDao(String nombre, String pais, int titulos, String entrenador, String presidente) {
		Equipo eq = new Equipo();
		equipo.setNombre(nombre);
		equipo.setPais(pais);
		equipo.setTitulos(titulos);
		equipo.setEntrenador(entrenador);
		equipo.setPresidente(presidente);
		this.equipo = eq;
	}
	
	public EquipoDao() {
		// Constructor vacío
	}


	@Override
	public String toString() {
		return "Equipo [Nombre=" + equipo.getNombre() + ", Pais=" + equipo.getPais() + ", Titulos=" + equipo.getTitulos() + ", Entrenador="
				+ equipo.getEntrenador() + ", Presidente=" + equipo.getPresidente() + "]";
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
		EquipoDao equipoCreado = new EquipoDao(nombre,pais,titulos,entrenador,presidente);
		System.out.println("Equipo que acabas de crear:");
		System.out.println(equipoCreado);
		esperar(3);
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


	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	

}
