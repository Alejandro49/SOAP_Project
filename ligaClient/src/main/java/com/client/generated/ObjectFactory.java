
package com.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Equipo_QNAME = new QName("http://liga.sw.com/", "Equipo");
    private final static QName _CrearEquipo_QNAME = new QName("http://liga.sw.com/", "crearEquipo");
    private final static QName _CrearEquipoResponse_QNAME = new QName("http://liga.sw.com/", "crearEquipoResponse");
    private final static QName _Hello_QNAME = new QName("http://liga.sw.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://liga.sw.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Equipo }
     * 
     */
    public Equipo createEquipo() {
        return new Equipo();
    }

    /**
     * Create an instance of {@link CrearEquipo }
     * 
     */
    public CrearEquipo createCrearEquipo() {
        return new CrearEquipo();
    }

    /**
     * Create an instance of {@link CrearEquipoResponse }
     * 
     */
    public CrearEquipoResponse createCrearEquipoResponse() {
        return new CrearEquipoResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Equipo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Equipo }{@code >}
     */
    @XmlElementDecl(namespace = "http://liga.sw.com/", name = "Equipo")
    public JAXBElement<Equipo> createEquipo(Equipo value) {
        return new JAXBElement<Equipo>(_Equipo_QNAME, Equipo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEquipo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearEquipo }{@code >}
     */
    @XmlElementDecl(namespace = "http://liga.sw.com/", name = "crearEquipo")
    public JAXBElement<CrearEquipo> createCrearEquipo(CrearEquipo value) {
        return new JAXBElement<CrearEquipo>(_CrearEquipo_QNAME, CrearEquipo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearEquipoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearEquipoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://liga.sw.com/", name = "crearEquipoResponse")
    public JAXBElement<CrearEquipoResponse> createCrearEquipoResponse(CrearEquipoResponse value) {
        return new JAXBElement<CrearEquipoResponse>(_CrearEquipoResponse_QNAME, CrearEquipoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://liga.sw.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://liga.sw.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
