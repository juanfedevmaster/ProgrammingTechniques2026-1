package com.juanfedevmaster.abarrotesdonpanchowebapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanfedevmaster.abarrotesdonpanchowebapi.model.Cliente;
import com.juanfedevmaster.abarrotesdonpanchowebapi.services.ClienteServicio;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteServicio clienteServicio;

    @GetMapping("/getAllClientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        var clientes = clienteServicio.getAllClientes(); 
        return clientes.size() > 0 ? 
            ResponseEntity.ok(clienteServicio.getAllClientes()) : 
            ResponseEntity.noContent().build();
    }

    @GetMapping("/getById")
    public ResponseEntity<Cliente> getById(@RequestParam String cedula) {
        var cliente = clienteServicio.getById(cedula);
        return cliente != null ? 
            ResponseEntity.ok(clienteServicio.getById(cedula)) :
            ResponseEntity.notFound().build();
    }
    
    
}
