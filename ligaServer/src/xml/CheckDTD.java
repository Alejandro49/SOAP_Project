package xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CheckDTD {
	
	public String validarLiga(String nombreArchivo) {
		
		String ruta = "./xml/" + nombreArchivo;
		
		File xmlFile = new File(ruta);
		String mensaje = "";
		
		try {
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			dBF.setValidating(true);
			DocumentBuilder builder = dBF.newDocumentBuilder();
			CustomErrorHandler customErrorHandler = new CustomErrorHandler();
			builder.setErrorHandler(customErrorHandler);
			Document doc = builder.parse(xmlFile);
			if (customErrorHandler.isValid()) {
				mensaje = xmlFile + " was valid!";
			} else {
				mensaje = xmlFile + " was not valid!";
			}
		} catch (ParserConfigurationException ex) {
			mensaje = xmlFile + " error while parsing!";
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			mensaje = xmlFile + " was not well-formed!";
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			mensaje = xmlFile + " was not accesible!";
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		}

		return mensaje;
	}
		
		
}
