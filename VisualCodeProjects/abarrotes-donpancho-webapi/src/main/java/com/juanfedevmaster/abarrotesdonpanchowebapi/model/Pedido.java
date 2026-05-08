package com.juanfedevmaster.abarrotesdonpanchowebapi.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id; //"id" integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY (sequence name "Products_id_seq"),

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "cedula_cliente",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_clientes")
    )
    private Cliente cliente;
}
