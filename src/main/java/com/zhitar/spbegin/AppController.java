package com.zhitar.spbegin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    public String hello() {
        return "index";
    }

}
