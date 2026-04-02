package com.weg.ClientePedido.repository;

import com.weg.ClientePedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByIdAndNome(Long id, String nome);
}
