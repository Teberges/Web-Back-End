package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {

    @Autowired
    private EntityManager entityManager; // Permite obter a classe desejada

    @Transactional
    public CategoriaProdutoRepository inserir(CategoriaProdutoRepository categoriaProduto) {
        return entityManager.merge(categoriaProduto);
    }

    @Transactional
    public CategoriaProdutoRepository salvar(CategoriaProdutoRepository categoriaProduto){
        return entityManager.merge(categoriaProduto);
    }

    public List<CategoriaProdutoRepository> obterTodos(){
        return entityManager.createQuery("from CategoriaProduto", CategoriaProdutoRepository.class).getResultList();
    }

    public List<CategoriaProdutoRepository> obterPorNome(String nome){
        return entityManager.createQuery("from CategoriaProduto where nome = :nome", CategoriaProdutoRepository.class)
            .setParameter("nome", nome)
            .getResultList();
    }
}