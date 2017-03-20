package com.company.dao;


import com.company.models.SmsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SmsDaoImpl implements SmsDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<SmsEntity> getAllSms(){
        return getCurrentSession().createQuery("from SmsEntity ").list();
    }
}
