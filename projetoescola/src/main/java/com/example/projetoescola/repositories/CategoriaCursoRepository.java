package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCursos;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

    @Repository
    public class CategoriaCursoRepository {

        @Autowired
        private EntityManager entityManager; // Permite obter a classe desejada
    

        @Transactional
        public CategoriaCursos inserir(CategoriaCursos categoriaCurso) {
            return entityManager.merge(categoriaCurso);
        }
        
        public CategoriaCursos salvar(CategoriaCursos categoriaCursos){
            return entityManager.merge(categoriaCursos);

        }
        
        public List<CategoriaCursos> obterTodos(){
            return entityManager.createQuery("from CategoriaCursos", CategoriaCursos.class).getResultList();
        }
    
        public List<CategoriaCursos> obterPorNome(String nome){
            return entityManager.createQuery("from CategoriaCurso where nome = :nome", CategoriaCursos.class)
                .setParameter("nome", nome)
                .getResultList();
        }
    }

