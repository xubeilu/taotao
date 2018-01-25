package com.taotao.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/{page}")
    public String list(@PathVariable(value = "page") String page){

        return page;
    }
}
