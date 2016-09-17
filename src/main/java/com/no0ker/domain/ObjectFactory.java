
package com.no0ker.domain;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.no0ker.domain package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.no0ker.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetEventRequest }
     * 
     */
    public SetEventRequest createSetEventRequest() {
        return new SetEventRequest();
    }

    /**
     * Create an instance of {@link Thing }
     * 
     */
    public Thing createThing() {
        return new Thing();
    }

    /**
     * Create an instance of {@link SetEventResponse }
     * 
     */
    public SetEventResponse createSetEventResponse() {
        return new SetEventResponse();
    }

    /**
     * Create an instance of {@link StatusContainer }
     * 
     */
    public StatusContainer createStatusContainer() {
        return new StatusContainer();
    }

}
