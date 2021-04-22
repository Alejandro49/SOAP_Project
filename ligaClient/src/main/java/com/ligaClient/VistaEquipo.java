package com.ligaClient;

import com.client.generated.Equipo;

public class VistaEquipo {
	
	private Equipo equipo;
	
	public VistaEquipo (Equipo eq) {
		this.equipo = eq;
	}
	
	@Override
	public String toString() {
		return "Equipo [Nombre=" + equipo.getNombre() + ", Pais=" + equipo.getPais() + ", Titulos=" + equipo.getTitulos() + ", Entrenador="
				+ equipo.getEntrenador() + ", Presidente=" + equipo.getPresidente() + "]";
	}

}
