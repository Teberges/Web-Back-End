package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer produto;

    @ManyToOne
    @JoinColumn(name = "Categoria_id")
    private Categoria categoria;
    private Integer Produto;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto(Long id, String nome, Integer produto) {
        this.id = id;
        this.nome = nome;
        this.Produto = produto;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getProduto() {
        return Produto;
    }

    public void setCargahoraria(Integer Produto) {
        this.Produto = Produto;
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nome=" + nome + ", Produto=" + Produto + "]";
    }
}
