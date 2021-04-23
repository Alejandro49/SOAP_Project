package modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.client.generated.Equipo;
import com.client.generated.Liga;

public class LigaDao {
	
	private Liga liga;
	
	public LigaDao (Liga liga) {
		this.liga = liga;
	}
	
	public LigaDao() {
		// Constructor vacío
	}

	public void mostrarLiga() {
		for (Equipo equipo: liga.getEquipo()) {
			EquipoDao equipoDao = new EquipoDao(equipo);
			System.out.println(equipoDao);
			esperar(2);
		}
	}
	
	public boolean removeEquipo(String nombre) {
		Equipo equipo = new Equipo();
		equipo.setNombre(nombre);
		return liga.getEquipo().remove(equipo);
	}

	public void addEquipo(Equipo e) {
		if(!liga.getEquipo().contains(e))
			liga.getEquipo().add(e);
	}
	
	public Equipo getEquipo(Equipo eq) {
		int index = liga.getEquipo().indexOf(eq);
		if (index == -1) {
			return null;
		} else {
			return liga.getEquipo().get(index);
		}
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	

}
