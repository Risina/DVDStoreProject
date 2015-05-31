
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for storeDVDUtil complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="storeDVDUtil">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="addedEmployeeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="releasedYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storeDVDUtil", propOrder = {
    "actors",
    "addedDate",
    "addedEmployeeId",
    "format",
    "modifiedDate",
    "rating",
    "releasedYear",
    "title"
})
public class StoreDVDUtil {

    protected String actors;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar addedDate;
    protected int addedEmployeeId;
    protected String format;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifiedDate;
    protected String rating;
    protected String releasedYear;
    protected String title;

    /**
     * Gets the value of the actors property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActors() {
        return actors;
    }

    /**
     * Sets the value of the actors property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActors(String value) {
        this.actors = value;
    }

    /**
     * Gets the value of the addedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAddedDate() {
        return addedDate;
    }

    /**
     * Sets the value of the addedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAddedDate(XMLGregorianCalendar value) {
        this.addedDate = value;
    }

    /**
     * Gets the value of the addedEmployeeId property.
     * 
     */
    public int getAddedEmployeeId() {
        return addedEmployeeId;
    }

    /**
     * Sets the value of the addedEmployeeId property.
     * 
     */
    public void setAddedEmployeeId(int value) {
        this.addedEmployeeId = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifiedDate(XMLGregorianCalendar value) {
        this.modifiedDate = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the releasedYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleasedYear() {
        return releasedYear;
    }

    /**
     * Sets the value of the releasedYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleasedYear(String value) {
        this.releasedYear = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

}
