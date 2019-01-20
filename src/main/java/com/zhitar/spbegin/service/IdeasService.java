package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dto.IdeaDTO;
import com.zhitar.spbegin.model.Idea;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IdeasService {

    long add(IdeaDTO idea);

    void update(IdeaDTO idea);

    void delete(long id);

    IdeaDTO get(long id);

    List<IdeaDTO> list();
}
