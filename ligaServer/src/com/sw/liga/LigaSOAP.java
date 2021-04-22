package com.sw.liga;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import pojos.Equipo;
import pojos.Liga;
import xml.LigaXML;

@WebService (serviceName = "ligaSOAP")

public class LigaSOAP {
	
	LigaXML ligaXML = new LigaXML();
	Liga liga;
	
	
	
	@WebMethod (operationName = "crearLiga")
	public void crearLiga (@WebParam(name = "ligaNueva") ArrayList<Equipo> ligaNueva) {
		liga = new Liga();
		liga.setLiga(ligaNueva);
	}
	
	@WebMethod (operationName = "obtenerLiga")
	public Liga obtenerLiga() {
		return liga;
	}
	
	@WebMethod (operationName = "anadirEquipo")
	public boolean anadirEquipo (@WebParam(name = "equipoNuevo") Equipo equipoNuevo) {
		if (liga == null) {
		 return false;
		} else {
			liga.addEquipo(equipoNuevo);
			return true;
		}
	}
	
	@WebMethod (operationName = "obtenerEquipo")
	public Equipo obtenerEquipo(@WebParam(name = "nombreEquipo") String nombreEquipo) {
		Equipo equipoAObtener = new Equipo();
		equipoAObtener.setNombre(nombreEquipo);
		return liga.getEquipo(equipoAObtener);
	}
	
	@WebMethod (operationName = "exportarLiga")
	public boolean exportarLiga() {
		if (liga == null) {
			return false;
		} else {
			try {
				ligaXML.exportarLiga(liga);
				return true;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
	}
	
	@WebMethod (operationName = "exportarEquipo")
	public boolean exportarEquipo(@WebParam(name = "equipoAExportar") Equipo equipoAExportar) {
		try {
			ligaXML.exportarEquipo(equipoAExportar);
			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod (operationName = "importarLiga")
	public boolean importarLiga(@WebParam(name = "nombreFichero") String nombreFichero) {
		try {
			ligaXML.importarLiga(nombreFichero);
			liga = ligaXML.getLiga();
			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod (operationName = "importarEquipo")
	public boolean importarEquipo(@WebParam(name = "nombreFichero") String nombreFichero) {
		try {
			liga.addEquipo(ligaXML.importarEquipo(nombreFichero));
			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@WebMethod (operationName = "inicializarLigaPredefinida")
	public Liga cargarLigaPredefinida() {
		try {
			ligaXML.importarLigaPredefinida();
			liga = ligaXML.getLiga();
			return this.liga;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
}
