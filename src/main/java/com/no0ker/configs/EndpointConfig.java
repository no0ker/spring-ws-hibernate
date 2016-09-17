package com.no0ker.configs;

import com.no0ker.domain.SetEventRequest;
import com.no0ker.domain.SetEventResponse;
import com.no0ker.model.Event;
import com.no0ker.model.EventDAO;
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

@Endpoint
public class EndpointConfig {
    private static final String NAMESPACE_URI = "https://github.com/no0ker/MyExampleVer2Application";

    //    private DbHelper dbHelper;
    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private HibernateTransactionManager transactionManager;

//    public EndpointConfig(EventDAO eventDAO) {
//        this.eventDAO = eventDAO;
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setEventRequest")
    @ResponsePayload
    public SetEventResponse eventsProcessor(@RequestPayload SetEventRequest request) {

        SetEventResponse response = new SetEventResponse();
        response.setName(request.getName());
        Event event = new Event();
        event.setName(request.getName());

        new TransactionTemplate(transactionManager).execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                eventDAO.save(event);
                return null;
            }
        });
//
//        try{
//            dbHelper.saveEvent(eventName);
//        } catch (DataAccessException e){
//            StatusContainer statusContainer = new StatusContainer();
//            statusContainer.setStatus(Status.FAIL);
//            statusContainer.setError(e.getClass().getName());
//            response.getStatusContainer().add(statusContainer);
//
//            return response;
//        }
//
//        for(Thing thing : request.getThings()){
//            try
//            {
//                Something something = new Something();
//                something.setValue1(thing.getValue1());
//                something.setValue2(thing.getValue2());
//
//                somethingDAO.save(something);
//
//                StatusContainer statusContainer = new StatusContainer();
//                statusContainer.setStatus(Status.SUCCESFULL);
//                statusContainer.setThing(thing);
//                response.getStatusContainer().add(statusContainer);
//            }
//            catch (DataAccessException e)
//            {
//                StatusContainer statusContainer = new StatusContainer();
//                statusContainer.setStatus(Status.FAIL);
//                statusContainer.setThing(thing);
//                statusContainer.setError(e.getClass().getName());
//                response.getStatusContainer().add(statusContainer);
//            }
//        }
        return response;
    }
}