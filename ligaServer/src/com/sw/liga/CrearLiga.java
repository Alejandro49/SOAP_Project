package com.sw.liga;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pojos.Equipo;

@WebService (serviceName = "CrearLigaService")

public class CrearLiga {
	
	
	
	@WebMethod (operationName = "crearEquipo")
	public Equipo crearEquipo() {
		Equipo equipo = new Equipo("Burgos", "España", 44, "Alejandro", "Zidane");
		return equipo;
	}
	
	@WebMethod (operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		return"Hello" + txt+ " !";
	}
	
}
