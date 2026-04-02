package com.weg.ClientePedido.repository;

import com.weg.ClientePedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByIdAndDescricao(Long id, String descricao);

    List<Pedido> findByClienteIdOrderByIdAsc(Long id);

    List<Pedido> findByClienteNomeOrderByIdAsc(String nome);
}
