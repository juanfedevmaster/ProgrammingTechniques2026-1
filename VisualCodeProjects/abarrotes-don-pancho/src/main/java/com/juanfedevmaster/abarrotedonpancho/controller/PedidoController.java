package com.juanfedevmaster.abarrotedonpancho.controller;

import com.juanfedevmaster.abarrotedonpancho.entity.Pedido;
import com.juanfedevmaster.abarrotedonpancho.service.PedidoService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable Long id) {
        return pedidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{cedula}")
    public ResponseEntity<List<Pedido>> getByCliente(@PathVariable String cedula) {
        return ResponseEntity.ok(pedidoService.findByCliente(cedula));
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestParam String cedula, @RequestBody Pedido pedido) {
        return pedidoService.save(cedula, pedido)
                .map(saved -> ResponseEntity.status(HttpStatus.CREATED).body(saved))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(
            @PathVariable Long id,
            @RequestParam String cedula,
            @RequestBody Pedido pedido) {
        return pedidoService.update(id, cedula, pedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return pedidoService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
