package com.zhitar.spbegin.dao;

import com.zhitar.spbegin.model.Idea;
import com.zhitar.spbegin.model.User;

import java.util.List;

public interface IdeasDAO {

    long add(Idea idea);

    long update(Idea idea);

    void delete(long id);

    Idea get(long id);

    List<Idea> list();

    boolean registerUser(User user);

    boolean isUserExists(String login);
}
