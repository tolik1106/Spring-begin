package com.zhitar.spbegin.service;

import com.zhitar.spbegin.dao.IdeasDAO;
import com.zhitar.spbegin.dto.IdeaDTO;
import com.zhitar.spbegin.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class IdeasServiceImpl implements IdeasService {

    @Autowired
    private IdeasDAO dao;

    @Transactional
    public long add(IdeaDTO idea) {
        return dao.add(convert(idea));
    }

    @Transactional
    public void update(IdeaDTO idea) {
        dao.update(convert(idea));
    }

    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    public IdeaDTO get(long id) {
        return convert(dao.get(id));
    }

    public List<IdeaDTO> list() {
        return dao.list().stream().map(IdeasServiceImpl::convert).collect(Collectors.toList());
    }

    private static Idea convert(IdeaDTO idea) {
        Idea modelIdea = new Idea();
        modelIdea.setId(idea.getId());
        modelIdea.setContent(idea.getContent());
        modelIdea.setCaption(idea.getCaption());
        modelIdea.setLikes(idea.getLikes());
        modelIdea.setDislikes(idea.getDislikes());
        return modelIdea;
    }

    private static IdeaDTO convert(Idea idea) {
        IdeaDTO ideaDTO = new IdeaDTO();
        ideaDTO.setId(idea.getId());
        ideaDTO.setContent(idea.getContent());
        ideaDTO.setCaption(idea.getCaption());
        ideaDTO.setLikes(idea.getLikes());
        ideaDTO.setDislikes(idea.getDislikes());
        return ideaDTO;
    }
}
