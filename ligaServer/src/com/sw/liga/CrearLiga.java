package com.sw.liga;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService (serviceName = "CrearLigaService")

public class CrearLiga {
	
	@WebMethod (operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		return"Hello" + txt+ " !";
	}
	
	@WebMethod (operationName = "sumar")
	public double suma(double d1,double d2){
		return d1+d2;
	}
	
	@WebMethod (operationName = "rand")
	public Double rand(){
		return Math.random();
	}

}
