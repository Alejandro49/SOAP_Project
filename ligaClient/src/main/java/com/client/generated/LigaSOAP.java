
package com.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LigaSOAP", targetNamespace = "http://liga.sw.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LigaSOAP {


    /**
     * 
     * @return
     *     returns com.client.generated.Liga
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inicializarLigaPredefinida", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.InicializarLigaPredefinida")
    @ResponseWrapper(localName = "inicializarLigaPredefinidaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.InicializarLigaPredefinidaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/inicializarLigaPredefinidaRequest", output = "http://liga.sw.com/LigaSOAP/inicializarLigaPredefinidaResponse")
    public Liga inicializarLigaPredefinida();

    /**
     * 
     * @param nombreEquipo
     * @return
     *     returns com.client.generated.Equipo
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerEquipo", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ObtenerEquipo")
    @ResponseWrapper(localName = "obtenerEquipoResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ObtenerEquipoResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/obtenerEquipoRequest", output = "http://liga.sw.com/LigaSOAP/obtenerEquipoResponse")
    public Equipo obtenerEquipo(
        @WebParam(name = "nombreEquipo", targetNamespace = "")
        String nombreEquipo);

    /**
     * 
     * @param equipoNuevo
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "anadirEquipo", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.AnadirEquipo")
    @ResponseWrapper(localName = "anadirEquipoResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.AnadirEquipoResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/anadirEquipoRequest", output = "http://liga.sw.com/LigaSOAP/anadirEquipoResponse")
    public boolean anadirEquipo(
        @WebParam(name = "equipoNuevo", targetNamespace = "")
        Equipo equipoNuevo);

    /**
     * 
     * @param ligaNueva
     */
    @WebMethod
    @RequestWrapper(localName = "crearLiga", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.CrearLiga")
    @ResponseWrapper(localName = "crearLigaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.CrearLigaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/crearLigaRequest", output = "http://liga.sw.com/LigaSOAP/crearLigaResponse")
    public void crearLiga(
        @WebParam(name = "ligaNueva", targetNamespace = "")
        List<Equipo> ligaNueva);

    /**
     * 
     * @param nombreEquipo
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "borrarEquipo", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.BorrarEquipo")
    @ResponseWrapper(localName = "borrarEquipoResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.BorrarEquipoResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/borrarEquipoRequest", output = "http://liga.sw.com/LigaSOAP/borrarEquipoResponse")
    public boolean borrarEquipo(
        @WebParam(name = "nombreEquipo", targetNamespace = "")
        String nombreEquipo);

    /**
     * 
     * @param nombreEquipo
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "exportarEquipo", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ExportarEquipo")
    @ResponseWrapper(localName = "exportarEquipoResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ExportarEquipoResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/exportarEquipoRequest", output = "http://liga.sw.com/LigaSOAP/exportarEquipoResponse")
    public int exportarEquipo(
        @WebParam(name = "nombreEquipo", targetNamespace = "")
        String nombreEquipo);

    /**
     * 
     * @return
     *     returns com.client.generated.Liga
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerLiga", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ObtenerLiga")
    @ResponseWrapper(localName = "obtenerLigaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ObtenerLigaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/obtenerLigaRequest", output = "http://liga.sw.com/LigaSOAP/obtenerLigaResponse")
    public Liga obtenerLiga();

    /**
     * 
     * @param nombreArchivo
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "exportarLiga", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ExportarLiga")
    @ResponseWrapper(localName = "exportarLigaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ExportarLigaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/exportarLigaRequest", output = "http://liga.sw.com/LigaSOAP/exportarLigaResponse")
    public int exportarLiga(
        @WebParam(name = "nombreArchivo", targetNamespace = "")
        String nombreArchivo);

    /**
     * 
     * @param nombreFichero
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "importarEquipo", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ImportarEquipo")
    @ResponseWrapper(localName = "importarEquipoResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ImportarEquipoResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/importarEquipoRequest", output = "http://liga.sw.com/LigaSOAP/importarEquipoResponse")
    public int importarEquipo(
        @WebParam(name = "nombreFichero", targetNamespace = "")
        String nombreFichero);

    /**
     * 
     * @param nombreFichero
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "importarLiga", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ImportarLiga")
    @ResponseWrapper(localName = "importarLigaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ImportarLigaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/importarLigaRequest", output = "http://liga.sw.com/LigaSOAP/importarLigaResponse")
    public boolean importarLiga(
        @WebParam(name = "nombreFichero", targetNamespace = "")
        String nombreFichero);

    /**
     * 
     * @param nombreFichero
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validarLiga", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ValidarLiga")
    @ResponseWrapper(localName = "validarLigaResponse", targetNamespace = "http://liga.sw.com/", className = "com.client.generated.ValidarLigaResponse")
    @Action(input = "http://liga.sw.com/LigaSOAP/validarLigaRequest", output = "http://liga.sw.com/LigaSOAP/validarLigaResponse")
    public String validarLiga(
        @WebParam(name = "nombreFichero", targetNamespace = "")
        String nombreFichero);

}
