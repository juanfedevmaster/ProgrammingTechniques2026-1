package com.juanfedevmaster.abarrotesdonpanchowebapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juanfedevmaster.abarrotesdonpanchowebapi.model.Cliente;
import com.juanfedevmaster.abarrotesdonpanchowebapi.repositories.ClienteRepositorio;

@Service
public class ClienteServicio {
    private final ClienteRepositorio clienteRepo;

    public ClienteServicio(ClienteRepositorio clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public List<Cliente> getAllClientes() {
        return this.clienteRepo.findAll();
    }
}
