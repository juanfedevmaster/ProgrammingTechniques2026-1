package com.juanfedevmaster.abarrotedonpancho.controller;

import com.juanfedevmaster.abarrotedonpancho.entity.Cliente;
import com.juanfedevmaster.abarrotedonpancho.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Cliente> getById(@PathVariable String cedula) {
        return clienteService.findByCedula(cedula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<Cliente> update(@PathVariable String cedula, @RequestBody Cliente cliente) {
        return clienteService.update(cedula, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> delete(@PathVariable String cedula) {
        return clienteService.delete(cedula)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
