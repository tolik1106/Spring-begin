package com.zhitar.spbegin.dao;

import com.zhitar.spbegin.model.Idea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public long add(Idea idea) {
        Serializable id = sessionFactory.getCurrentSession().save(idea);
        return (Long) id;
    }

    @Override
    public long update(Idea idea) {
        Session session = sessionFactory.getCurrentSession();
        session.update(idea);
        return idea.getId();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Idea idea = session.load(Idea.class, id);
        session.delete(idea);
    }

    @Override
    public Idea get(long id) {
        Session session = sessionFactory.getCurrentSession();
        Idea idea = session.get(Idea.class, id);
        return idea;
    }

    @Override
    public List<Idea> list() {
        Session session = sessionFactory.getCurrentSession();
        List list = session.createQuery("from Idea").list();
        return list;
    }
}
