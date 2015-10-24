package com.mackittipat.connectionpool.connwebapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping(value = "/save")
    public String save() {
        return "Saved";
    }
}
