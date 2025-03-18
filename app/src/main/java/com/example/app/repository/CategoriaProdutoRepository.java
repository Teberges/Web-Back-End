package com.example.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.models.Categoria;

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
    public Categoria salvar(Categoria categori){
        return entityManager.merge(categori);
    }

    public List<CategoriaProdutoRepository> obterTodos(){
        return entityManager.createQuery("from Categoria", CategoriaProdutoRepository.class).getResultList();
    }

    public List<Categoria> obterPorNome(String nome){
        return entityManager.createQuery("from Categoria where nome = :nome", Categoria.class)
            .setParameter("nome", nome)
            .getResultList();
    }
}