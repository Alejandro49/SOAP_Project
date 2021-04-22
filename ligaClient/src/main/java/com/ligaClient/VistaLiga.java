package com.ligaClient;

import com.client.generated.Equipo;
import com.client.generated.Liga;

public class VistaLiga {
	
	private Liga liga;
	
	public VistaLiga (Liga liga) {
		this.liga = liga;
	}
	
	public void mostrarLiga() {
		for (Equipo equipo: liga.getEquipo()) {
			VistaEquipo vistaEq = new VistaEquipo(equipo);
			System.out.println(vistaEq);
			esperar(2);
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
