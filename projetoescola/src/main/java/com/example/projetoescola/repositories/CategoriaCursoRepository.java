package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaCurso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

    @Repository
    public class CategoriaCursoRepository {

        @Autowired
        private EntityManager entityManager; // Permite obter a classe desejada
    

        @Transactional
        public CategoriaCurso inserir(CategoriaCurso categoriaCurso) {
            return entityManager.merge(categoriaCurso);
        }
        @Transactional
        public CategoriaCurso salvar(CategoriaCurso categoriaCursos){
            return entityManager.merge(categoriaCursos);

        }
        
        public List<CategoriaCurso> obterTodos(){
            return entityManager.createQuery("from CategoriaCurso", CategoriaCurso.class).getResultList();
        }
    
        public List<CategoriaCurso> obterPorNome(String nome){
            return entityManager.createQuery("from CategoriaCurso where nome = :nome", CategoriaCurso.class)
                .setParameter("nome", nome)
                .getResultList();
        }
    }

