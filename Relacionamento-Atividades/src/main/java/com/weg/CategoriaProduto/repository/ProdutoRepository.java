package com.weg.CategoriaProduto.repository;

import com.weg.CategoriaProduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoriaNome(String nome);

    Optional<Produto> findByNome(String nome);

    Optional<Produto> findByIdAndNome(Long id, String nome);
}
