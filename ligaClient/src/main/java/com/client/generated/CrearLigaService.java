
package com.client.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CrearLigaService", targetNamespace = "http://liga.sw.com/", wsdlLocation = "http://localhost:8080/ligaServer/ws/crearLiga?wsdl")
public class CrearLigaService
    extends Service
{

    private final static URL CREARLIGASERVICE_WSDL_LOCATION;
    private final static WebServiceException CREARLIGASERVICE_EXCEPTION;
    private final static QName CREARLIGASERVICE_QNAME = new QName("http://liga.sw.com/", "CrearLigaService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ligaServer/ws/crearLiga?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CREARLIGASERVICE_WSDL_LOCATION = url;
        CREARLIGASERVICE_EXCEPTION = e;
    }

    public CrearLigaService() {
        super(__getWsdlLocation(), CREARLIGASERVICE_QNAME);
    }

    public CrearLigaService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CREARLIGASERVICE_QNAME, features);
    }

    public CrearLigaService(URL wsdlLocation) {
        super(wsdlLocation, CREARLIGASERVICE_QNAME);
    }

    public CrearLigaService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CREARLIGASERVICE_QNAME, features);
    }

    public CrearLigaService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CrearLigaService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CrearLiga
     */
    @WebEndpoint(name = "CrearLigaPort")
    public CrearLiga getCrearLigaPort() {
        return super.getPort(new QName("http://liga.sw.com/", "CrearLigaPort"), CrearLiga.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CrearLiga
     */
    @WebEndpoint(name = "CrearLigaPort")
    public CrearLiga getCrearLigaPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://liga.sw.com/", "CrearLigaPort"), CrearLiga.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CREARLIGASERVICE_EXCEPTION!= null) {
            throw CREARLIGASERVICE_EXCEPTION;
        }
        return CREARLIGASERVICE_WSDL_LOCATION;
    }

}
