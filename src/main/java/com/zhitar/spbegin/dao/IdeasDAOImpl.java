package com.zhitar.spbegin.dao;

import com.zhitar.spbegin.model.Idea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdeasDAOImpl implements IdeasDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long add(Idea idea) {
        Session session = sessionFactory.openSession();
        return (Long) session.save(idea);
    }

    @Override
    public void update(Idea idea) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Idea get(long id) {
        return null;
    }

    @Override
    public List<Idea> list() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Idea").list();
    }
}
