package com.juanfedevmaster.abarrotesdonpanchowebapi.model;

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
@Table(name="Clientes")
@Entity
public class Cliente {
    @Id
    private String cedula;
    private String nombres;
    private String apellidos;
    private String celular;
}
