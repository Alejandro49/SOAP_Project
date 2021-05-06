package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import pojos.Equipo;
import pojos.Liga;


public class LigaXML {
	
	private Liga liga = new Liga();
	private String ruta = "";
	
	public void cargarLigaPredefinida() throws JAXBException {
		
		Equipo eq1 = new Equipo("Real Madrid", "España", 92, "Zinedine Zidane", "Florentino Pérez");
		Equipo eq2 = new Equipo("Paris Saint-Germain", "Francia", 42, "Mauricio Pochettino", "Nasser Al-Khelaïfi");
		Equipo eq3 = new Equipo("Sevilla FC", "España", 14, "Julen Lopetegui", "José Castro Carmona");
		Equipo eq4 = new Equipo("Chelsea FC", "Inglaterra", 33, "Thomas Tuchel", "Bruce Buck");
		
		liga.addEquipos(eq1, eq2, eq3, eq4);
	}
	
	public void exportarLiga(String nombreArchivo) throws JAXBException {
		String ruta = this.ruta + nombreArchivo + ".xml";
		//Marshalling()
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		//jaxbM.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE Liga SYSTEM \"liga.dtd\">");
        jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		// Escribiendo en un fichero
		File XMLfile = new File(ruta);
		jaxbM.marshal(liga, XMLfile);

	}
	
	public void importarLiga(String nombreFichero) throws JAXBException {
		String ruta = this.ruta + nombreFichero;
		JAXBContext jaxbC = JAXBContext.newInstance(Liga.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		//jaxbU.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		//jaxbU.setProperty("com.sun.xml.bind.xmlHeaders", "\n<!DOCTYPE Liga SYSTEM \"liga.dtd\">");
       // jaxbU.setProperty("com.sun.xml.bind.xmlDeclaration", false);
		File XMLfile = new File(ruta);
		liga = (Liga) jaxbU.unmarshal(XMLfile);
	}
	
	public boolean importarEquipo(String nombreFichero) throws JAXBException {
		String ruta = this.ruta + nombreFichero;
		JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
		File XMLfile = new File(ruta);
		Equipo equipo = (Equipo) jaxbU.unmarshal(XMLfile);
		
		return liga.addEquipo(equipo);
	}
	
	public  void exportarEquipo(Equipo eq) throws JAXBException {
		String ruta = this.ruta + eq.getNombre() + ".xml";
		// Creamos el JAXBContext
		JAXBContext jaxbC = JAXBContext.newInstance(Equipo.class);
		// Creamos el JAXBMarshaller
		Marshaller jaxbM = jaxbC.createMarshaller();
		// Formateo bonito
		jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
		jaxbM.setProperty("com.sun.xml.bind.xmlDeclaration", false);
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

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
	
	
	
	

}
