package com.juanfedevmaster.abarrotedonpancho.service;

import com.juanfedevmaster.abarrotedonpancho.entity.Producto;
import com.juanfedevmaster.abarrotedonpancho.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> update(Integer id, Producto productoData) {
        return productoRepository.findById(id).map(existing -> {
            existing.setName(productoData.getName());
            existing.setProductCode(productoData.getProductCode());
            existing.setPrice(productoData.getPrice());
            existing.setDateCreation(productoData.getDateCreation());
            return productoRepository.save(existing);
        });
    }

    public boolean delete(Integer id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }
}
