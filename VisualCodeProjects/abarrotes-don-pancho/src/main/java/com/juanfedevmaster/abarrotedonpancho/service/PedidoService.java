package com.juanfedevmaster.abarrotedonpancho.service;

import com.juanfedevmaster.abarrotedonpancho.entity.Cliente;
import com.juanfedevmaster.abarrotedonpancho.entity.Pedido;
import com.juanfedevmaster.abarrotedonpancho.repository.ClienteRepository;
import com.juanfedevmaster.abarrotedonpancho.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findByCliente(String cedula) {
        return pedidoRepository.findByClienteCedula(cedula);
    }

    public Optional<Pedido> save(String cedula, Pedido pedido) {
        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if (cliente.isEmpty()) {
            return Optional.empty();
        }
        pedido.setCliente(cliente.get());
        return Optional.of(pedidoRepository.save(pedido));
    }

    public Optional<Pedido> update(Long id, String cedula, Pedido pedidoData) {
        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if (cliente.isEmpty()) {
            return Optional.empty();
        }
        return pedidoRepository.findById(id).map(existing -> {
            existing.setCliente(cliente.get());
            existing.setFechaPedido(pedidoData.getFechaPedido());
            return pedidoRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!pedidoRepository.existsById(id)) {
            return false;
        }
        pedidoRepository.deleteById(id);
        return true;
    }
}
