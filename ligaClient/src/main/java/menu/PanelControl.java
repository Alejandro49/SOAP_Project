package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.client.generated.Liga;
import com.client.generated.LigaSOAP;
import com.client.generated.LigaSOAP_Service;
import com.ligaClient.VistaLiga;
import com.sun.tools.javac.Main;

public class PanelControl {
	
	LigaSOAP_Service servicio = new LigaSOAP_Service();
	
	LigaSOAP ligaSOAP;
	
	Liga liga;
	
	
	Scanner sc1;
	Scanner sc2;
	Scanner sc3;
	Scanner sc4;
	Scanner sc5;
	Scanner sc6;
	Scanner sc7;
	
	public void cargarPanel() { //sc1
		
		ligaSOAP = servicio.getLigaSOAPPort();
		
		System.out.println("¿Que desea hacer?");
		System.out.println("1.- Cargar Liga Predefinida");
		System.out.println("2.- Importar liga");
		System.out.println("3.- Exportar liga");
		System.out.println("4.- Crear liga");
		System.out.println("5.- Mostrar equipos de la liga");
		System.out.println("6.- Añadir equipo a la liga");
		System.out.println("7.- Borrar equipo de la liga");
		System.out.println("8.- Importar Equipo desde xml");
		System.out.println("9.- Exportar equipo a xml");
		System.out.println("10.- Validar liga con DTD");
		System.out.println("11.- Salir");
		System.out.println();
		System.out.println("Escriba el número de la opción que quiere ejecutar");
		
		int opcion = 0;
		try {
			sc1 = new Scanner(System.in);
			opcion = sc1.nextInt();
			
		} catch (InputMismatchException ime){
			System.out.println("Debes introducir un n�mero entero. Vuelve a intentarlo");
			esperar(2);
		}
		
		if (opcion>0 && opcion<12) {
			ejecutarOpcion(opcion);
		} else {
			System.out.println("Opci�n incorrecta. Vuelva a intentarlo");
			cargarPanel();
		}
		
	}
	
	public void ejecutarOpcion(int opcion) { //sc2
		
		switch(opcion) {
		case 1:
			cargarLigaPredefinida();
		break;
		case 2: //Importar liga
			importarLiga();		   
		break;
		case 3: // Exportar liga
			marshallLiga();
		break;
		case 4: //Crear liga
			crearLiga();
		break;
		case 5: // Mostrar equipos
			
			if (liga == null || liga.getEquipo().isEmpty()) {
				System.out.println("Liga vacía, debes importarla o crearla primero");
				esperar(2);
			} else {
				System.out.println("Mostrando los equipos de la liga:");
				VistaLiga vistaLiga = new VistaLiga(liga);
				vistaLiga.mostrarLiga();
			}
			
		break;
		case 6: // Añadir equipo manualmente
			if (ligaXML.getLiga() == null) {
				System.out.println("Liga inexistente, debes crearla o importarla primero para poder a�adir equipos");
				esperar(2);
			} else {
				ligaXML.getLiga().leerEquipoDeTeclado();
			}
		break;
		case 7: // Borrar equipo mediante su nombre // sc6
			borrarEquipo();
		break;
		case 8: 
			unMarhallEquipo();
		break;
		case 9:
			marshallEquipo();
		break;
		case 10:
			validarLigaConDTD();
		break;
		case 11:
			System.out.println("¡Hasta pronto!");
			esperar(2);
			System.exit(0);
		break;
		}
		
		cargarPanel();
	}


	private void borrarEquipo() {
		if (ligaXML.getLiga() == null) {
			System.out.println("Liga inexistente.");
			esperar(2);
		} else {
			sc6 = new Scanner(System.in);
			System.out.println("Introduzca el nombre del equipo a borrar");
			String nombre = sc6.nextLine();
			boolean borrado = ligaXML.getLiga().removeEquipo(nombre);
			if (borrado==true) {
				System.out.println("Equipo eliminado correctamente");
				esperar(2);
			} else {
				System.out.println("No existe un equipo con ese nombre en la liga");
				esperar(2);
			}
		}
	}

	private void validarLigaConDTD() {
		System.out.println("Introduzca el documento xml a validar por DTD liga.dtd");
		System.out.println("El documento debe de estar en la carpeta ./xml/archivo.xml");
		System.out.println("Puede escribir si lo desea nuestro archivo por defecto para dtd. Escriba \"ligaDTD.xml\" para validar"
				+ " nuestra liga por defecto");
		validadorDTD = new CheckDTD();
		sc5 = new Scanner(System.in);
		String nombreArchivo = sc5.nextLine();
		validadorDTD.validarLiga(nombreArchivo);
		esperar(3);
	}

	private void crearLiga() {
		Liga liga = new Liga(); //liga vac�a inicialmente
		System.out.println("Inserte los equipos de forma manual");
		esperar(2);
		String respuesta = "";
		do {
			sc2 = new Scanner(System.in);
			System.out.println("Introduzca los datos del nuevo equipo:");
			System.out.println("Introduce nombre del equipo:");
			String nombre =  sc2.nextLine();
			System.out.println("Introduce nombre del pais:");
			String pais =  sc2.nextLine();
			int titulos = titulosEquipo();
			System.out.println("Introduce nombre del entrenador del equipo:");
			String entrenador =  sc2.nextLine();
			System.out.println("Introduce nombre del presidente del equipo:");
			String presidente =  sc2.nextLine();
			Equipo equipoCreado = new Equipo(nombre,pais,titulos,entrenador,presidente);
			System.out.println("Equipo que acabas de crear:");
			System.out.println(equipoCreado);
			esperar(3);
			System.out.println("Escriba \"ok\" para a�adirlo a la liga");
			String confirmacion = sc2.nextLine();
			if (confirmacion.equals("ok")) {
				liga.addEquipo(equipoCreado);
				System.out.println("Equipo a�adido a la liga");
			}
			System.out.println("Escriba \"no\" para finalizar la insercion de equipos o cualquier otra tecla para seguir a�adiendo equipos ");
			respuesta = sc2.nextLine();
		} while (respuesta.equals("no") == false);
		System.out.println("Creacion de la liga completada");
		esperar(2);
		ligaXML.setLiga(liga);
	}
	
	private void marshallEquipo() { //sc4
		sc4 = new Scanner(System.in);
		System.out.println("Introduzca el nombre exacto del equipo que quieres exportar");
		String nombre = sc4.nextLine();
		Equipo eq = new Equipo();
		eq.setNombre(nombre);
		try {
			eq = ligaXML.getLiga().getEquipo(eq);
		} catch (NullPointerException ex) {
			System.out.println("Error, liga inexistente, importala o creala primero");
			esperar(2);
			return;
		}
		if (eq == null) {
			System.out.println("Ese equipo no est� en la liga");
			esperar(2);
		} else {
			try {
				ligaXML.exportarEquipo(eq);
				String mensaje = "Equipo exportado a ./xml/" + eq.getNombre() + ".xml";
				System.out.println(mensaje);
				esperar(2);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}

	private boolean unMarhallEquipo() {
		Equipo equipo = new Equipo();
		sc3 = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero a importar (debe de estar dentro de ./xml/Nombre_Fichero.xml");
		String nombreFichero = sc3.nextLine();
		try {
			equipo = ligaXML.importarEquipo(nombreFichero);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			return false;
		} catch (IllegalArgumentException ex) {
			System.out.println("No se ha encontrado el archivo");
			esperar(2);
			return false;
		}
		if (ligaXML.getLiga() == null) {
			Liga liga2 = new Liga();
			liga2.addEquipo(equipo);
			ligaXML.setLiga(liga2);
		} else { 
			ligaXML.getLiga().addEquipo(equipo);
		}
		System.out.println("Se ha importado el equipo correctamente, seleccione la opcion mostrar para verlo");
		esperar(2);
		return true;
	}

	private void marshallLiga() {
		System.out.println("Exportando liga al archivo ./xml/ligaExportada.xml");
		try {
			ligaXML.exportarLiga(ligaXML.getLiga());
			System.out.println("Liga exportada con �xito");
			esperar(2);
		   } catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Se ha producido un error inesperado");
			esperar(1);
		   } catch (IllegalArgumentException e) {
			   System.out.println("Liga actualmente inexistente, importala primero, o a�ade equipos por consola");
			   esperar(2);
		   }
	}
	
	private void importarLiga() { //sc7
		sc7 = new Scanner(System.in);
		System.out.println("Tenemos las siguientes ligas almacenadas en la base de datos: ");
		System.out.println("liga1.xml");
		System.out.println("liga2.xml");
		System.out.println("liga3.xml");
		System.out.println("ligaExportada.xml  (En caso de que hayas exportado una liga anteriormente)");
		System.out.println("Introduzca el nombre del fichero de la liga a importar (Nombre_Fichero.xml)");
		String nombreFichero = sc7.nextLine();
		
		if (ligaSOAP.importarLiga(nombreFichero)) {
			Liga ligaImportada = ligaSOAP.obtenerLiga();
			liga = ligaImportada;
			System.out.println("Liga importada correctamente");
			System.out.println("Elija la opción Mostrar para ver los equipos que conforman la liga");
			esperar(2);
		} else {
			System.out.println("Error 500. Fatal Sever Error");
			esperar(2);
		}
		
	}
	
	

	private void cargarLigaPredefinida() {
		
		System.out.println("Inicializado ligaPredefinida.xml");
		liga = ligaSOAP.inicializarLigaPredefinida();
		
		if (liga == null) {
			System.out.println("Error 500. Fatal Sever Error");
			esperar(2);
			return;
		} else {
			System.out.println("Liga predefinida cargada con éxito");
		}
			
		System.out.println("Elija la opción Mostrar para ver los equipos que conforman la liga");
		esperar(2);
	}
	
	
	
	private int titulosEquipo() {
		int titulos = -1;
		Scanner lectorTitulos;
		do {
			try {
				lectorTitulos = new Scanner(System.in);
				System.out.println("Introduce el n� de t�tulos del equipo: ");
				titulos = lectorTitulos.nextInt();
			} catch (InputMismatchException ime){
				System.out.println("Debes introducir un numero entero carapan, no veas lo que cuesta gestionar excepciones...");
				esperar(2);
			}
			
		} while (titulos<0);
		
		return titulos;
	}

	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	
	
}
