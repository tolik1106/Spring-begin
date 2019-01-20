package com.zhitar.spbegin.controller;

import com.zhitar.spbegin.model.Idea;
import com.zhitar.spbegin.service.IdeasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class AppController {

    @Autowired
    private IdeasService service;

    @GetMapping("/list")
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

    @GetMapping("/update")
    public ModelAndView updateForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("updateForm");
        modelAndView.getModelMap().addAttribute("newIdea", service.get(id));
        return modelAndView;
    }

    @PostMapping("/new")
    public String createIdea(@ModelAttribute Idea idea) {
        service.add(idea);
        return "redirect:/list";
    }

    @PostMapping("/update")
    public ModelAndView updateAction(@ModelAttribute Idea newIdea) {
        service.update(newIdea);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id) {
        service.delete(id);
        return new ModelAndView("redirect:/list");
    }
}
