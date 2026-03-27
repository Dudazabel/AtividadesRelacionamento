package com.weg.Relacionamento_FuncionarioDepartamento.repository;

import com.weg.Relacionamento_FuncionarioDepartamento.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
