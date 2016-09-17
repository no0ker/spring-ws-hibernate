
package com.no0ker.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusContainer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statusContainer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="thing" type="{https://github.com/no0ker/MyExampleVer2Application}thing"/>
 *         &lt;element name="status" type="{https://github.com/no0ker/MyExampleVer2Application}status"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statusContainer", namespace = "https://github.com/no0ker/MyExampleVer2Application", propOrder = {
    "thing",
    "status",
    "error"
})
public class StatusContainer {

    @XmlElement(namespace = "https://github.com/no0ker/MyExampleVer2Application", required = true)
    protected Thing thing;
    @XmlElement(namespace = "https://github.com/no0ker/MyExampleVer2Application", required = true)
    protected Status status;
    @XmlElement(namespace = "https://github.com/no0ker/MyExampleVer2Application")
    protected String error;

    /**
     * Gets the value of the thing property.
     * 
     * @return
     *     possible object is
     *     {@link Thing }
     *     
     */
    public Thing getThing() {
        return thing;
    }

    /**
     * Sets the value of the thing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Thing }
     *     
     */
    public void setThing(Thing value) {
        this.thing = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

}
