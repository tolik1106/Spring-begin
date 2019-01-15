package com.zhitar.spbegin.service;

import com.zhitar.spbegin.model.Idea;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IdeasService {

    long add(Idea idea);

    void update(Idea idea);

    void delete(long id);

    Idea get(long id);

    List<Idea> list();
}
