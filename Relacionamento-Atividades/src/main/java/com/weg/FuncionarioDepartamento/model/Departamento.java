package com.weg.FuncionarioDepartamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nomeGestor;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

    public Departamento(String nome, String nomeGestor) {
        this.nome = nome;
        this.nomeGestor = nomeGestor;
    }
}
