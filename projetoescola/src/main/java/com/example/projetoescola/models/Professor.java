package com.example.projetoescola.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Professor {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String nome;
private Double salario;
public Professor(Long id, String nome, Double salario) {
this.id = id;
this.nome = nome;
this.salario = salario;
}
public Professor() {
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
public Double getsalario() {
return salario;
}
public void setsalario(Double salario) {
this.salario = salario;
}
@Override
public String toString() {
return "Professor [id=" + id + ", nome=" + nome + ", salario=" + salario + "]";
}
}