package com.openapi.weather.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {


    @GetMapping("/")
    public String index(Model model){
        log.info("index page");
        model.addAttribute("name", "name");
        return "indexPage";
    }
}
