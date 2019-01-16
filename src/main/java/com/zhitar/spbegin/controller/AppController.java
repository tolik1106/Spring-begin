package com.zhitar.spbegin.controller;

import com.zhitar.spbegin.model.Idea;
import com.zhitar.spbegin.service.IdeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Controller
public class AppController {

    @Autowired
    private IdeasService service;

    @GetMapping
    public String hello(ModelMap map) {
        List<Idea> ideas = service.list();
        map.addAttribute("list", ideas);
        return "index";
    }

    @GetMapping("/new")
    public String createForm(ModelMap map) {
        map.addAttribute("idea", new Idea());
        return "form";
    }

    @PostMapping("/new")
    public String createIdea(@ModelAttribute Idea idea) {
        service.add(idea);
        return "redirect:/";
    }
}
