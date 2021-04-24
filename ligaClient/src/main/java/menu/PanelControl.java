package menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.client.generated.Equipo;
import com.client.generated.Liga;
import com.client.generated.LigaSOAP;
import com.client.generated.LigaSOAP_Service;
import com.sun.tools.javac.Main;

import modelo.EquipoDao;
import modelo.LigaDao;

public class PanelControl {
	
	LigaSOAP_Service servicio = new LigaSOAP_Service();
	
	LigaSOAP ligaSOAP;
	
	LigaDao ligaDao = new LigaDao();
	EquipoDao equipoDao = new EquipoDao();
	
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
			exportarLiga();
		break;
		case 4: //Crear liga
			crearLiga();
		break;
		case 5: // Mostrar equipos
			ligaDao.setLiga(ligaSOAP.obtenerLiga());
			ligaDao.mostrarLiga();
		break;
		case 6: // Añadir equipo manualmente
				EquipoDao equipoAInsertar = equipoDao.leerEquipoDeTeclado();
				Scanner sc = new Scanner(System.in);
				System.out.println("Escriba \"ok\" para añadirlo a la liga");
				String confirmacion = sc.nextLine();
				if (confirmacion.equals("ok")) {
					if (ligaSOAP.anadirEquipo(equipoAInsertar.getEquipo())) {
						System.out.println("Equipo añadido a la liga");
						esperar(2);
					} else {
						System.out.println("Ya existe un equipo con ese nombre en la liga.");
						esperar(2);
					}
				} else {
					System.out.println("No se ha añadido a la liga");
					esperar(2);
				}
				
		break;
		case 7: // Borrar equipo mediante su nombre // sc6
			sc6 = new Scanner(System.in);
			System.out.println("Introduzca el nombre del equipo a borrar");
			String nombreEquipo = sc6.nextLine();
			boolean borrado = ligaSOAP.borrarEquipo(nombreEquipo);
			if (borrado==true) {
				System.out.println("Equipo eliminado correctamente");
				esperar(2);
			} else {
				System.out.println("No existe un equipo con ese nombre en la liga");
				esperar(2);
			}
		break;
		case 8:
			importarEquipo();
		break;
		case 9:
			exportarEquipo();
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
	
	private void cargarLigaPredefinida() {
		
		System.out.println("cargando ligaPredefinida.xml...");
		esperar(2);
		Liga liga = ligaSOAP.inicializarLigaPredefinida();
		if (liga == null) {
			System.out.println("Error del servidor (500)");
			esperar(2);
		} else {
			System.out.println("Liga Predefinida cargada con éxito");
			System.out.println("Elija la opción 5 para ver los equipos que conforman la liga");
			esperar(2);
		}
	}
	
	private void importarLiga() { //sc7
		sc7 = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero de la liga a importar (Nombre_Fichero.xml)");
		String nombreFichero = sc7.nextLine();
		if (ligaSOAP.importarLiga(nombreFichero)) {
			System.out.println("Liga importada correctamente");
			System.out.println("Elija la opción 5 para ver los equipos que conforman la liga");
			esperar(2);
		} else {
			String mensaje = "Archivo: \"" + nombreFichero + "\" no encontrado. Asegurese de escribir correctamente el nombre del archivo";
			System.out.println(mensaje);
			esperar(3);
		}	
	}
	
	private void exportarLiga() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero en el que se exportará la liga");
		String nombreFichero = sc.nextLine();
		int response = ligaSOAP.exportarLiga(nombreFichero);
		if (response == -1) {
			System.out.println("Error, Liga vacía, debes importarla o crearla primero");
			esperar(2);
		} else if (response == 0) {
			System.out.println("Error del servidor (500)");
			esperar(2);
		} else {
			String mensaje = "Liga exportada correctamente como archivo: \"" + nombreFichero + ".xml\"";
			esperar(2);
		}
	}
	
	private void crearLiga() {  
		LigaDao ligaDao = new LigaDao(); 
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
			EquipoDao equipoCreado = new EquipoDao(nombre,pais,titulos,entrenador,presidente);
			System.out.println("Equipo que acabas de crear:");
			System.out.println(equipoCreado);
			esperar(3);
			System.out.println("Escriba \"ok\" para a�adirlo a la liga");
			String confirmacion = sc2.nextLine();
			if (confirmacion.equals("ok")) {
				boolean insercion = ligaDao.addEquipo(equipoCreado.getEquipo());
				if (insercion == true) {
					System.out.println("Equipo añadido a la liga");
				} else {
					System.out.println("Error, ya hay un equipo con ese nombre en la liga");
				}
				
			}
			System.out.println("Escriba \"no\" para finalizar la insercion de equipos o cualquier otra tecla para seguir a�adiendo equipos ");
			respuesta = sc2.nextLine();
		} while (respuesta.equals("no") == false);
		
		ligaSOAP.crearLiga(ligaDao.getLiga().getEquipo());
		System.out.println("Creacion de la liga completada");
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
	
	private void importarEquipo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del fichero que contiene el equipo a importar (archivo.xml)");
		String nombreFichero = sc.nextLine();
		int resultado = ligaSOAP.importarEquipo(nombreFichero);
		if (resultado == -1) {
			System.out.println("Ese equipo ya esta en la liga, y por lo tanto, NO se puede importar");
			esperar(2);
		} else if (resultado == 0) {
			System.out.println("Archivo no encontrado, o xml mal formado");
			esperar(2);
		} else {
			System.out.println("Equipo importado a la liga con éxito");
			esperar(2);
		}
	}
	
	private void exportarEquipo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del equipo que quiere exportar a un archivo xml");
		String nombreEquipo = sc.nextLine();
		int resultado = ligaSOAP.exportarEquipo(nombreEquipo);
		if (resultado == -1) {
			System.out.println("Error, ese equipo no esta presente en la Liga");
			esperar(2);
		} else if (resultado == 0) {
			System.out.println("Error del servidor (500). No se ha completado la exportación del equipo");
			esperar(2);
		} else {
			String mensaje = "Equipo exportado correctamente en archivo: \"" + nombreEquipo + ".xml\"";
			System.out.println(mensaje);
			esperar(3);
		}
		
	}

	private void validarLigaConDTD() {
		System.out.println("Introduzca el documento xml a validar por DTD liga.dtd");
		System.out.println("El documento debe de estar en la carpeta ./xml/archivo.xml");
		System.out.println("Puede escribir si lo desea nuestro archivo por defecto para dtd. Escriba \"ligaDTD.xml\" para validar"
				+ " nuestra liga por defecto");
	//	validadorDTD = new CheckDTD();
		sc5 = new Scanner(System.in);
		String nombreArchivo = sc5.nextLine();
	//	validadorDTD.validarLiga(nombreArchivo);
		esperar(3);
	}

	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	
	
	
}
