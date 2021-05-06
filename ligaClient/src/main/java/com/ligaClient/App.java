package com.ligaClient;

import com.client.generated.LigaSOAP;
import com.client.generated.LigaSOAP_Service;

import menu.PanelControl;

public class App {
	
	private static PanelControl panel = new PanelControl();
	
    public static void main( String[] args )  {
    	
    	System.out.println("Bienvenido a la Superliga... cargando panel de control");
		esperar(3);
		panel.cargarPanel();
    	
    }
    
    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
}
