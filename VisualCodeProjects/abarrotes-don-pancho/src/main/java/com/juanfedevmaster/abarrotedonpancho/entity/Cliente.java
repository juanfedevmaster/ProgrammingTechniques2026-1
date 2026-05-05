package com.juanfedevmaster.abarrotedonpancho.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @Column(name = "cedula", length = 10, nullable = false)
    private String cedula;

    @Column(name = "nombres", length = 150, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 150, nullable = false)
    private String apellidos;

    @Column(name = "celular", length = 10, nullable = false)
    private String celular;
}
