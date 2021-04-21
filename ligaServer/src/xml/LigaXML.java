package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pojos.Equipo;
import pojos.Liga;


public class LigaXML {
	
	private Liga liga;
	private Equipo equipo;
	
	public void importarLigaPredefinida() throws JAXBException {
		//unMarshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		// Leyendo un fichero
		File XMLfile = new File("./xml/ligaPredefinida.xml");
		// Creando el objeto
		liga = (Liga) jaxbU.unmarshal(XMLfile);
		// Escribiendo por pantalla el objeto
	}
	
	public void exportarLiga(Liga liga) throws JAXBException {
		//Marshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE Liga SYSTEM \"liga.dtd\">");
        jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File("./xml/ligaExportada.xml");
		jaxbM.marshal(liga, XMLfile);

	}
	
	public void importarLiga(String nombreFichero) throws JAXBException {
		String ruta = "./xml/" + nombreFichero;
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File XMLfile = new File(ruta);
		liga = (Liga) jaxbU.unmarshal(XMLfile);
	}
	
	public Equipo importarEquipo(String nombreFichero) throws JAXBException {
		String ruta = "./xml/" + nombreFichero;
		JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File XMLfile = new File(ruta);
		Equipo equipo = (Equipo) jaxbU.unmarshal(XMLfile);
		return equipo;
	}
	
	public  void exportarEquipo(Equipo eq) throws JAXBException {
		String ruta = "./xml/" + eq.getNombre() + ".xml";
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		//jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File(ruta);
		jaxbM.marshal(eq, XMLfile);
		// Escribiendo por pantalla
		//jaxbM.marshal(book, System.out);
	}
	

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}
	
	
	
	

}
