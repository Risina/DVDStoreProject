
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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

    private final static QName _GetDVDById_QNAME = new QName("http://services/", "getDVDById");
    private final static QName _AddDVD_QNAME = new QName("http://services/", "addDVD");
    private final static QName _AddDVDResponse_QNAME = new QName("http://services/", "addDVDResponse");
    private final static QName _GetDVDByIdResponse_QNAME = new QName("http://services/", "getDVDByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDVDByIdResponse }
     * 
     */
    public GetDVDByIdResponse createGetDVDByIdResponse() {
        return new GetDVDByIdResponse();
    }

    /**
     * Create an instance of {@link AddDVDResponse }
     * 
     */
    public AddDVDResponse createAddDVDResponse() {
        return new AddDVDResponse();
    }

    /**
     * Create an instance of {@link AddDVD }
     * 
     */
    public AddDVD createAddDVD() {
        return new AddDVD();
    }

    /**
     * Create an instance of {@link GetDVDById }
     * 
     */
    public GetDVDById createGetDVDById() {
        return new GetDVDById();
    }

    /**
     * Create an instance of {@link StoreDVDUtil }
     * 
     */
    public StoreDVDUtil createStoreDVDUtil() {
        return new StoreDVDUtil();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDVDById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getDVDById")
    public JAXBElement<GetDVDById> createGetDVDById(GetDVDById value) {
        return new JAXBElement<GetDVDById>(_GetDVDById_QNAME, GetDVDById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDVD }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addDVD")
    public JAXBElement<AddDVD> createAddDVD(AddDVD value) {
        return new JAXBElement<AddDVD>(_AddDVD_QNAME, AddDVD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDVDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "addDVDResponse")
    public JAXBElement<AddDVDResponse> createAddDVDResponse(AddDVDResponse value) {
        return new JAXBElement<AddDVDResponse>(_AddDVDResponse_QNAME, AddDVDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDVDByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services/", name = "getDVDByIdResponse")
    public JAXBElement<GetDVDByIdResponse> createGetDVDByIdResponse(GetDVDByIdResponse value) {
        return new JAXBElement<GetDVDByIdResponse>(_GetDVDByIdResponse_QNAME, GetDVDByIdResponse.class, null, value);
    }

}
