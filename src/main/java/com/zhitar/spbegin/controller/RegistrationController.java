package com.zhitar.spbegin.controller;

import com.zhitar.spbegin.dto.RegistrationUserDTO;
import com.zhitar.spbegin.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("registration_form");
        view.getModelMap().addAttribute("user", new RegistrationUserDTO());
        return view;
    }

    @PostMapping(name = "/login")
    public ModelAndView register(@ModelAttribute(value = "user") @Valid RegistrationUserDTO userDTO,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return  new ModelAndView("registration_form", "user", userDTO);
        }

        if (service.isUserExists(userDTO.getLogin())) {
            result.rejectValue("login", "error.login", "User with this email is exist!");
            return  new ModelAndView("registration_form", "user", userDTO);
        }
        service.register(userDTO);
        return new ModelAndView("redirect:list");
    }
}
