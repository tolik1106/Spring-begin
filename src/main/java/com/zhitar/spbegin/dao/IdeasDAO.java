package com.zhitar.spbegin.dao;

import com.zhitar.spbegin.model.Idea;

import java.util.List;

public interface IdeasDAO {

    long add(Idea idea);

    void update(Idea idea);

    void delete(long id);

    Idea get(long id);

    List<Idea> list();
}
