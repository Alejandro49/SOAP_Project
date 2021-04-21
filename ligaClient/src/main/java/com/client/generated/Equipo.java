
package com.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para equipo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="equipo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="titulos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="entrenador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="presidente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="pais" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "equipo", propOrder = {
    "titulos",
    "entrenador",
    "presidente"
})
public class Equipo {

    protected int titulos;
    protected String entrenador;
    protected String presidente;
    @XmlAttribute(name = "nombre")
    protected String nombre;
    @XmlAttribute(name = "pais")
    protected String pais;
    
    public String toString() {
		return "Equipo [Nombre=" + nombre + ", Pais=" + pais + ", Titulos=" + titulos + ", Entrenador="
				+ entrenador + ", Presidente=" + presidente + "]";
	}

    /**
     * Obtiene el valor de la propiedad titulos.
     * 
     */
    public int getTitulos() {
        return titulos;
    }

    /**
     * Define el valor de la propiedad titulos.
     * 
     */
    public void setTitulos(int value) {
        this.titulos = value;
    }

    /**
     * Obtiene el valor de la propiedad entrenador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntrenador() {
        return entrenador;
    }

    /**
     * Define el valor de la propiedad entrenador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntrenador(String value) {
        this.entrenador = value;
    }

    /**
     * Obtiene el valor de la propiedad presidente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresidente() {
        return presidente;
    }

    /**
     * Define el valor de la propiedad presidente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresidente(String value) {
        this.presidente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

}
