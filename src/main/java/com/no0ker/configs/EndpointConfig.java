package com.no0ker.configs;

import com.no0ker.domain.*;
import com.no0ker.model.Event;
import com.no0ker.model.EventDAO;
import com.no0ker.model.ThingDAO;
import org.springframework.beans.ExtendedBeanInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.transaction.TransactionManager;
import java.util.Date;

@Endpoint
public class EndpointConfig {
    private static final String NAMESPACE_URI = "https://github.com/no0ker/MyExampleVer2Application";

    private TransactionTemplate transactionTemplate;
    private EventDAO eventDAO;
    private ThingDAO thingDAO;

    @Autowired
    public EndpointConfig(EventDAO eventDAO, HibernateTransactionManager transactionManager, ThingDAO thingDAO) {
        this.eventDAO = eventDAO;
        this.thingDAO = thingDAO;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setEventRequest")
    @ResponsePayload
    public SetEventResponse eventsProcessor(@RequestPayload SetEventRequest request) {
        SetEventResponse response = new SetEventResponse();

        try {
            transactionTemplate.execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus transactionStatus) {
                    Event event = new Event(request.getName(), new Date());
                    eventDAO.save(event);
                    response.setName(request.getName());
                    return null;
                }
            });
        } catch (Exception e) {
            response.setName(e.getClass().getName());
        }

        for (Thing thing : request.getThings()) {
            com.no0ker.model.Thing savedThing = new com.no0ker.model.Thing(thing.getValue1(), thing.getValue2());
            StatusContainer statusContainer = new StatusContainer();
            statusContainer.setThing(thing);

            try {
                transactionTemplate.execute(new TransactionCallback<Object>() {
                    @Override
                    public Object doInTransaction(TransactionStatus transactionStatus) {
                        thingDAO.save(savedThing);
                        statusContainer.setStatus(Status.SUCCESFULL);
                        return null;
                    }
                });
            } catch (Exception e) {
                statusContainer.setStatus(Status.FAIL);
                statusContainer.setError(e.getClass().getName());
            }
            response.getStatusContainer().add(statusContainer);
        }

        return response;
    }
}