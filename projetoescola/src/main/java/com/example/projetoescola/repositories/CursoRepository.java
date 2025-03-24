package com.example.projetoescola.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projetoescola.models.Curso;
{
public interface CursoRepository extends JpaRepository<Curso, Long>

}
   