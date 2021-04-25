package modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.client.generated.Equipo;
import com.client.generated.Liga;

public class LigaDao {
	
	private Liga liga = new Liga();
	
	public LigaDao (Liga liga) {
		this.liga = liga;
	}
	
	public LigaDao() {
		// Constructor vacío
	}

	public void mostrarLiga() {
		if (liga.getEquipo().isEmpty()) {
			System.out.println("Liga vacía, añade equipos primero, importarla o creala primero");
			esperar(2);
		} else {
			for (Equipo equipo: liga.getEquipo()) {
				EquipoDao equipoDao = new EquipoDao(equipo);
				System.out.println(equipoDao);
				esperar(2);
				}
		}
	}
	
	public boolean removeEquipo(String nombre) {
		Equipo equipo = new Equipo();
		equipo.setNombre(nombre);
		return liga.getEquipo().remove(equipo);
	}

		// devuelve false si ya hay un equipo con ese nombre en la liga, y por lo tanto no se puede importar
		// deuvelve true si se añade con exito el equipo a la liga
		public boolean addEquipo(Equipo equipoAInsertar) {
			for (Equipo equipo : liga.getEquipo()) {
				if (equipo.getNombre().equals(equipoAInsertar.getNombre())) {
					return false;
				}
			}
			 return liga.getEquipo().add(equipoAInsertar);
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
