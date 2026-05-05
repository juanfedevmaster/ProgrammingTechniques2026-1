package com.juanfedevmaster.abarrotedonpancho.repository;

import com.juanfedevmaster.abarrotedonpancho.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
