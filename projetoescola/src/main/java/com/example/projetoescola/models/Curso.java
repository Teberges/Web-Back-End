package com.example.projetoescola.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(length =  200, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer cargaHoraria;
    
    @ManyToOne
    @joinColumn(name = "CategoriaCurso_id")
    private CategoriaCurso categoriaCurso;

public Curso(long id, String nome, Integer cargaHoraria) {
    this.id = id;
    this.nome = nome;
    this.cargaHoraria = cargaHoraria;
}
public Curso() {
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public Integer getCargahoraria() {
    return cargaHoraria;
}
public void setCargahoraria(Integer cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
}
@Override
public String toString() {
    return "Curso [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + "]";
}
}
