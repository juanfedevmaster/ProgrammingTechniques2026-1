package com.juanfedevmaster.abarrotesdonpanchowebapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name="clientes")
@Entity
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
    @Column(name = "direccion", length = 150, nullable = false)
    private String direccion;
    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;
}
