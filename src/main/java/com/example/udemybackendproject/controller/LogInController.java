package com.example.udemybackendproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class LogInController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logInGetMessage(ModelMap modelMap, @RequestParam String name){
//        System.out.println("Name is :- " + name);
        modelMap.put("name",name);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String logInPostMessage(ModelMap modelMap, @RequestParam String name){
        System.out.println("Name is :- " + name);
        modelMap.put("name",name);
        return "login";
    }

}
