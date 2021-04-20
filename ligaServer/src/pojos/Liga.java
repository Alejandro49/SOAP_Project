package pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Liga")
@XmlAccessorType(XmlAccessType.FIELD)
public class Liga implements Serializable{

	private static final long serialVersionUID = -47891006084131330L;
	
	@XmlElement(name = "Equipo")
	private ArrayList<Equipo> liga;
	
	public Liga() {
		super();
		liga = new ArrayList<>();
	}
	
	
	public void addEquipo(Equipo e) {
		if(!liga.contains(e))
			liga.add(e);
	}
	
	public void removeEquipo(Equipo e) {
		liga.remove(e);
	}
	public boolean removeEquipo(String nombre) {
		Equipo equipo = new Equipo();
		equipo.setNombre(nombre);
		return liga.remove(equipo);
	}
	
	public void mostrarLiga() {
		if (liga == null || liga.isEmpty()) {
			System.out.println("Liga vacía, debes importarla o crearla primero");
			esperar(2);
		}
		for (Equipo equipo: liga) {
			esperar(1);
			System.out.println(equipo);
		}
	}
	
	public void leerEquipoDeTeclado() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca los datos del nuevo equipo:");
		System.out.println("Introduce nombre del equipo:");
		String nombre =  sc.nextLine();
		System.out.println("Introduce nombre del pais:");
		String pais =  sc.nextLine();
		int titulos = leerTitulosDeTeclado();
		System.out.println("Introduce nombre del entrenador del equipo:");
		String entrenador =  sc.nextLine();
		System.out.println("Introduce nombre del presidente del equipo:");
		String presidente =  sc.nextLine();
		Equipo equipoCreado = new Equipo(nombre,pais,titulos,entrenador,presidente);
		System.out.println("Equipo que acabas de crear:");
		System.out.println(equipoCreado);
		esperar(3);
		System.out.println("Escriba \"ok\" para añadirlo a la liga");
		String confirmacion = sc.nextLine();
		if (confirmacion.equals("ok")) {
			this.liga.add(equipoCreado);
			System.out.println("Equipo añadido a la liga");
			esperar(2);
		} else {
			System.out.println("No se ha añadido a la liga");
			esperar(2);
		}
	}
	
	private int leerTitulosDeTeclado() {
		
		int titulos = -1;
		Scanner lectorTitulos;
		do {
			try {
				lectorTitulos = new Scanner(System.in);
				System.out.println("Introduce el nº de títulos del equipo: ");
				titulos = lectorTitulos.nextInt();
			} catch (InputMismatchException ime){
				System.out.println("Debes introducir un numero entero, no veas lo que cuesta gestionar excepciones...");
				esperar(2);
			}
			
		} while (titulos<0);
		
		return titulos;
	}


	public Equipo getEquipo(Equipo eq) {
		int index = liga.indexOf(eq);
		if (index == -1) {
			return null;
		} else {
			return liga.get(index);
		}
	}
	
	public ArrayList<Equipo> getLiga() {
		return liga;
	}

	public void setLiga(ArrayList<Equipo> liga) {
		this.liga = liga;
	}
	
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }


	
}
