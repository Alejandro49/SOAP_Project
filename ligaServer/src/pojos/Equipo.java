package pojos;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "Equipo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"titulos", "entrenador", "presidente"})
public class Equipo  implements Serializable{

	private static final long serialVersionUID = -4723661295149279887L;
	
	@XmlAttribute
	private String nombre;
	@XmlAttribute
	private String pais;
	@XmlElement
	private int titulos;
	@XmlElement 
	private String entrenador;
	@XmlElement
	private String presidente;
	
	@XmlTransient
	private Liga liga;
	
	
	public Equipo() {
		super();
	}
	
	public Equipo(String nombre, String pais, int titulos, String entrenador, String presidente) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.titulos = titulos;
		this.entrenador = entrenador;
		this.presidente = presidente;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getNombre() {
        return nombre;
	}

	public void setNombre(String nombre) {
	        this.nombre = nombre;
	}
	
	public String getPais() {
        return pais;
	}

	public void setPais(String pais) {
	        this.pais = pais;
	}
	
	 public int getTitulos() {
	        return titulos;
	}
	
	public void setTitulos(int titulos) {
	        this.titulos = titulos;
	}
	
	 public String getEntrenador() {
	        return entrenador;
	}
	
	public void setEntrenador(String entrenador) {
	        this.entrenador = entrenador;
	}
	
	
	 public String getPresidente() {
	        return presidente;
	}
	
	public void setPresidente(String presidente) {
	        this.presidente = presidente;
	}
	@Override
	public String toString() {
		return "Equipo [Nombre=" + nombre + ", Pais=" + pais + ", Titulos=" + titulos + ", Entrenador="
				+ entrenador + ", Presidente=" + presidente + "]";
	}
}
