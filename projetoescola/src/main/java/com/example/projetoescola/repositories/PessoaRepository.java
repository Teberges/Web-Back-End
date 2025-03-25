package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class PessoaRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return entityManager.merge(pessoa);
    }

    public List<Pessoa> obterTodos() {
        return entityManager.createQuery("FROM Pessoa", Pessoa.class).getResultList();
    }
}