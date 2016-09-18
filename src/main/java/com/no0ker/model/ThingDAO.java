package com.no0ker.model;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ThingDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Thing thing){
        sessionFactory.getCurrentSession().save(thing);
    }
}
