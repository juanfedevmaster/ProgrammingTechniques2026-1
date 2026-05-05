package com.juanfedevmaster.abarrotedonpancho.service;

import com.juanfedevmaster.abarrotedonpancho.entity.Cliente;
import com.juanfedevmaster.abarrotedonpancho.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findByCedula(String cedula) {
        return clienteRepository.findById(cedula);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> update(String cedula, Cliente clienteData) {
        return clienteRepository.findById(cedula).map(existing -> {
            existing.setNombres(clienteData.getNombres());
            existing.setApellidos(clienteData.getApellidos());
            existing.setCelular(clienteData.getCelular());
            return clienteRepository.save(existing);
        });
    }

    public boolean delete(String cedula) {
        if (!clienteRepository.existsById(cedula)) {
            return false;
        }
        clienteRepository.deleteById(cedula);
        return true;
    }
}
