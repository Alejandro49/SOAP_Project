
package com.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para exportarEquipo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="exportarEquipo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nombreEquipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exportarEquipo", propOrder = {
    "nombreEquipo"
})
public class ExportarEquipo {

    protected String nombreEquipo;

    /**
     * Obtiene el valor de la propiedad nombreEquipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Define el valor de la propiedad nombreEquipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEquipo(String value) {
        this.nombreEquipo = value;
    }

}
