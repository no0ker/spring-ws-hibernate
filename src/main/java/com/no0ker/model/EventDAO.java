package com.no0ker.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void test(Event event){
        sessionFactory.openSession().save(event);
    }

}
