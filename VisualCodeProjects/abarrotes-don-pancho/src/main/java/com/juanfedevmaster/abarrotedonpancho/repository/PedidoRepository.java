package com.juanfedevmaster.abarrotedonpancho.repository;

import com.juanfedevmaster.abarrotedonpancho.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteCedula(String cedula);
}
