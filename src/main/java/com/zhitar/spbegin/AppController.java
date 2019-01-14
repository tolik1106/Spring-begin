package com.zhitar.spbegin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private SimpleDBAccess access;

    @GetMapping
    public String hello(ModelMap map) {
        map.addAttribute("db", access.getVersion());
        return "index";
    }

}
