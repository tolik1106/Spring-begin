package com.zhitar.spbegin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class SimpleDBAccess {

    @Autowired
    private SessionFactory sessionFactory;

    public String getVersion() {
        Session session = sessionFactory.openSession();
        String version = (String) session.createSQLQuery("select version()").getSingleResult();
        session.close();
        return version;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
