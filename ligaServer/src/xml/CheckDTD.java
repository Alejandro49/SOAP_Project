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
	
	public void validarLiga(String nombreArchivo) {
		
		String ruta = "./xml/" + nombreArchivo;
		
		File xmlFile = new File(ruta);
		
		try {
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			dBF.setValidating(true);
			DocumentBuilder builder = dBF.newDocumentBuilder();
			CustomErrorHandler customErrorHandler = new CustomErrorHandler();
			builder.setErrorHandler(customErrorHandler);
			Document doc = builder.parse(xmlFile);
			if (customErrorHandler.isValid()) {
				System.out.println(xmlFile + " was valid!");
			} else {
				System.out.println(xmlFile + " was not valid!");
			}
		} catch (ParserConfigurationException ex) {
			System.out.println(xmlFile + " error while parsing!");
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			System.out.println(xmlFile + " was not well-formed!");
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			System.out.println(xmlFile + " was not accesible!");
			Logger.getLogger(CheckDTD.class.getName()).log(Level.SEVERE, null, ex);
		}

		
	}
		
		
}
