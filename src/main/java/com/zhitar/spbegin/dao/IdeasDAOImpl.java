package com.zhitar.spbegin.dao;

import com.zhitar.spbegin.model.Idea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
public class IdeasDAOImpl implements IdeasDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public long add(Idea idea) {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(idea);
        session.close();
        return (Long) id;
    }

    @Override
    @Transactional
    public long update(Idea idea) {
        Session session = sessionFactory.openSession();
        session.update(idea);
        Serializable id = session.getIdentifier(session);
        session.close();
        return (Long) id;
    }

    @Override
    @Transactional
    public void delete(long id) {
        Session session = sessionFactory.openSession();
        Idea idea = session.load(Idea.class, id);
        session.delete(idea);
        session.close();
    }

    @Override
    public Idea get(long id) {
        Session session = sessionFactory.openSession();
        Idea idea = session.load(Idea.class, id);
        session.close();
        return idea;
    }

    @Override
    public List<Idea> list() {
        Session session = sessionFactory.openSession();
        List list = session.createQuery("from Idea").list();
        session.close();
        return list;
    }
}
