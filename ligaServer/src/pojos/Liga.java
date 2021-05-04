package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Liga")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liga implements Serializable{

	private static final long serialVersionUID = -47891006084131330L;
	
	@XmlElement(name = "Equipo")
	private ArrayList<Equipo> liga = new ArrayList<>();
	
	public Liga() {
		super();
	}
	
	// devuelve false si ya hay un equipo con ese nombre en la liga, y por lo tanto no se puede importar
	// deuvelve true si se añade con exito el equipo a la liga
	public boolean addEquipo(Equipo eq) {
		if(liga.contains(eq)) {
			return false;
		} else {
			liga.add(eq);
			return true;
		}
	}
	
	public void addEquipos(Equipo...equipos) {
		for (Equipo eq: equipos) {
			if(liga.contains(eq)) {
				
			} else {
				liga.add(eq);
			}
		}
	}
	
	//devuelve true si el equipo estaba en la liga y se ha borrado. Devuelve false si el equipo no estaba en la liga y por lo tanto, la lista no ha cambiado.
	public boolean removeEquipo(String nombreEquipo) {  //
		Equipo equipo = new Equipo(nombreEquipo);
		return liga.remove(equipo);
	}
	
	
	// devuelve null si no esta el equipo con ese nombre en la liga o te devuelve
	public Equipo getEquipo(String nombreEquipo) {
		Equipo equipo = new Equipo(nombreEquipo);
		int index = liga.indexOf(equipo);
		if (index == -1) {
			return null;
		} else {
			return liga.get(index);
		}
	}
	
	// devuelve true si la liga contiene un equipo con ese nombre
	public boolean contiene(String nombreEquipo) {
		Equipo eq = new Equipo(nombreEquipo);
		return liga.contains(eq);
	}
	
	public boolean isEmpty() {
		return liga.isEmpty();
	}
	
	public ArrayList<Equipo> getLiga() {
		return liga;
	}

	public void setLiga(ArrayList<Equipo> liga) {
		this.liga = liga;
	}
	
	


	
}
