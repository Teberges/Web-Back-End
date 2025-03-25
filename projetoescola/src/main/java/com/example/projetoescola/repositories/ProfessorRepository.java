package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
List<Professor> findBySalarioGreaterThan(Double salario);
List<Professor> findBySalarioLessThanEqual(Double salario);
List<Professor> findByNomeStartingWith(String nome);
}