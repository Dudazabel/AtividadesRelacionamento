package com.weg.Relacionamento_FuncionarioDepartamento.repository;

import com.weg.Relacionamento_FuncionarioDepartamento.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

   List<Funcionario> findByDepartamentoId(Long id);

   Optional<Funcionario> findByNome(String nome);

   Optional<Funcionario> findByIdAndNome(Long id, String nome);
}
