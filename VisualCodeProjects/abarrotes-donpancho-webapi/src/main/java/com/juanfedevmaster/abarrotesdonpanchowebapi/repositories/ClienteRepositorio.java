package com.juanfedevmaster.abarrotesdonpanchowebapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juanfedevmaster.abarrotesdonpanchowebapi.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String> {

}
