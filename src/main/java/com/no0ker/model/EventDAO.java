package com.no0ker.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EventDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Event event){
        sessionFactory.getCurrentSession().save(event);
    }
}
