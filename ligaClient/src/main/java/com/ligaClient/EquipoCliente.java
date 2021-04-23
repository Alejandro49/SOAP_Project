package com.ligaClient;

import com.client.generated.Equipo;

public class EquipoCliente {
	
	private Equipo equipo;
	
	public EquipoCliente (Equipo eq) {
		this.equipo = eq;
	}
	
	
	public EquipoCliente(String nombre, String pais, int titulos, String entrenador, String presidente) {
		Equipo eq = new Equipo();
		equipo.setNombre(nombre);
		equipo.setPais(pais);
		equipo.setTitulos(titulos);
		equipo.setEntrenador(entrenador);
		equipo.setPresidente(presidente);
		this.equipo = eq;
	}


	@Override
	public String toString() {
		return "Equipo [Nombre=" + equipo.getNombre() + ", Pais=" + equipo.getPais() + ", Titulos=" + equipo.getTitulos() + ", Entrenador="
				+ equipo.getEntrenador() + ", Presidente=" + equipo.getPresidente() + "]";
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	

}
