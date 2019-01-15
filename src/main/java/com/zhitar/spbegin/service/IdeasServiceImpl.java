package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dao.IdeasDAO;
import com.zhitar.spbegin.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeasServiceImpl implements IdeasService {

    @Autowired
    private IdeasDAO dao;

    public long add(Idea idea) {
        return dao.add(idea);
    }

    public void update(Idea idea) {
        dao.update(idea);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public Idea get(long id) {
        return dao.get(id);
    }

    public List<Idea> list() {
        return dao.list();
    }
}
