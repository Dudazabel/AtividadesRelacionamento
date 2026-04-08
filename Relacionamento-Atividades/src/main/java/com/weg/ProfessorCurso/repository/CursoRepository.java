package com.weg.ProfessorCurso.repository;

import com.weg.ProfessorCurso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByProfessorId(Long id);
    List<Curso> findByProfessorNome(String nome);

    Optional<Curso> findByIdAndNome(Long id, String nome);
}
