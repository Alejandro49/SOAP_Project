package com.sw.liga;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;

import pojos.Equipo;
import pojos.Liga;
import xml.CheckDTD;
import xml.LigaXML;

@WebService (serviceName = "ligaSOAP")

public class LigaSOAP {
	
	LigaXML ligaXML = new LigaXML();
	
	
	
	@WebMethod (operationName = "crearLiga")
	public void crearLiga (@WebParam(name = "ligaNueva") ArrayList<Equipo> ligaNueva) {
		Liga liga = new Liga();
		liga.setLiga(ligaNueva);
		ligaXML.setLiga(liga);
	}
	
	@WebMethod (operationName = "obtenerLiga")
	public Liga obtenerLiga() {
		return ligaXML.getLiga();
	}
	
	// devuelve true si se añade el equipo
	// devuelve false si ya hay un equipo con ese nombre en la liga
	@WebMethod (operationName = "anadirEquipo")
	public boolean anadirEquipo (@WebParam(name = "equipoNuevo") Equipo equipoNuevo) {
		 boolean insercion = ligaXML.getLiga().addEquipo(equipoNuevo);
		 return insercion;
	}
	
	//devuelve true si el equipo estaba en la liga y se ha borrado. Devuelve false si el equipo no estaba en la liga y por lo tanto, la lista no ha cambiado.
	@WebMethod (operationName = "borrarEquipo")
	public boolean borrarEquipo(@WebParam(name = "nombreEquipo") String nombreEquipo) {
		if (ligaXML.getLiga().removeEquipo(nombreEquipo)) {
			return true;
		} else {
			return false;
		}
	}
	
	// devuelve null si no esta el equipo con ese nombre en la liga, o te devuelve el equipo
	@WebMethod (operationName = "obtenerEquipo")
	public Equipo obtenerEquipo(@WebParam(name = "nombreEquipo") String nombreEquipo) {
		return ligaXML.getLiga().getEquipo(nombreEquipo);
	}
	
	// Devuelve 1 si se exporta correctamente a un archivo xml
	// Devuelve 0 si salta alguna excepción del marshalling a xml
	// Devuelve -1 si la liga esta vacía y por lo tanto, no tiene sentido exportarla.
	@WebMethod (operationName = "exportarLiga")
	public int exportarLiga(@WebParam(name = "nombreArchivo") String nombreArchivo) { 
		if (ligaXML.getLiga().isEmpty()) {
			return -1;
		} else {
			try {
				ligaXML.exportarLiga(nombreArchivo);
				return 1;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
	}
	// devuelve -1 si el equipo no esta en la liga
	// devuelve 0 si se produce una excepción xml
	// devuelve 1 si el equipo se ha exportado correctamente
	@WebMethod (operationName = "exportarEquipo")
	public int exportarEquipo(@WebParam(name = "nombreEquipo") String nombreEquipo ) {
		if (ligaXML.getLiga().contiene(nombreEquipo)) {
			Equipo equipoAExportar = ligaXML.getLiga().getEquipo(nombreEquipo);
			try {
				ligaXML.exportarEquipo(equipoAExportar);
				return 1;
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		} else {
			return -1;
		}
	}
	
	// devuelve true si la liga se ha importado al servidor con exito
	// devuelve false si ha saltado alguna excepción xml
	@WebMethod (operationName = "importarLiga")
	public boolean importarLiga(@WebParam(name = "nombreFichero") String nombreFichero) {
		try {
			ligaXML.importarLiga(nombreFichero);
			return true;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// fallo de archivo no encontrado
			return false;
		}
	}
	
	// devuelve -1 si ese equipo ya esta en la liga, y por lo tanto no se puede importar
	// devuelve 0 si se produce una excepción xml
	// devuelve 1 si el equipo se ha importado a la liga correctamente
	@WebMethod (operationName = "importarEquipo")
	public int importarEquipo(@WebParam(name = "nombreFichero") String nombreFichero) {
		try {
			 if (ligaXML.importarEquipo(nombreFichero)) {
				 return 1;
			 } else {
				 return -1;
			 }
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			// fallo de archivo no encontrado
			return 2;
		}
	}
	
	// Devuelve la liga predefinida o null, en caso de que haya habido un error al hacer unmarshall del documento xml de la liga,
	@WebMethod (operationName = "inicializarLigaPredefinida")
	public Liga cargarLigaPredefinida() {
		try {
			ligaXML.importarLigaPredefinida();
			return ligaXML.getLiga();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod (operationName = "validarLiga")
	public String validarLigaConDTD(@WebParam(name = "nombreFichero") String nombreFichero) {
		CheckDTD checker = new CheckDTD();
		return checker.validarLiga(nombreFichero);
	}
	
	
}
