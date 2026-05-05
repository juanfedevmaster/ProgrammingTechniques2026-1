package com.juanfedevmaster.abarrotedonpancho.repository;

import com.juanfedevmaster.abarrotedonpancho.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
