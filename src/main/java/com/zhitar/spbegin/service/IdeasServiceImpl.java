package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dao.IdeasDAO;
import com.zhitar.spbegin.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IdeasServiceImpl implements IdeasService {

    @Autowired
    private IdeasDAO dao;

    @Transactional
    public long add(Idea idea) {
        return dao.add(idea);
    }

    @Transactional
    public void update(Idea idea) {
        dao.update(idea);
    }

    @Transactional
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
