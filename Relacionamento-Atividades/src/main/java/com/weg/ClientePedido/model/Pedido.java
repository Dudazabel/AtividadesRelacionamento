package com.weg.ClientePedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String descricao;

    @ManyToOne
    private Cliente cliente;

    public Pedido(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
