package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaCursos {
    private Long id;
    private String name;
    @OneToMany(mappedBy = "CategoriaCurso")
    private List<Curso> cursos;

    public CategoriaCursos( Long id, String name){
        this.id= id; 
        this.name= name;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
