package com.zhitar.spbegin.controller;

import com.zhitar.spbegin.model.Idea;
import com.zhitar.spbegin.service.IdeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class AppController {

    @Autowired
    private IdeasService service;

    @GetMapping
    public String hello(ModelMap map) {

        Idea idea = generatedRandom();
        service.add(idea);

        List<Idea> ideas = service.list();

        map.addAttribute("list", ideas);
        return "index";
    }

    private Idea generatedRandom() {
        Random random = new Random();
        Idea idea = new Idea();
        idea.setLikes(random.nextInt(100));
        idea.setDislikes(random.nextInt(100));
        idea.setCaption(generatedString(random, 50));
        idea.setContent(generatedString(random, 1000));
        return idea;
    }

    private String generatedString(Random random, int max) {
        int length = random.nextInt(max - 10) + 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(random.nextInt(26) + 97));
            if (i % 10 == 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
