package com.juanfedevmaster.holamundowebapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HolaMundoController {
    
    @GetMapping("/hola")
    public String getHolaMundo() {
        return "Hola mundo desde mi primera aplicacion WebApi!!";
    }
    
}
