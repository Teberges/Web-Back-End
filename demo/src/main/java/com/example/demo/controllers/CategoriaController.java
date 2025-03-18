package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projetoescola.models.Categoria;
import com.example.projetoescola.repositories.CursoRepository;

import main.java.com.example.demo.models.Categoria;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    private CatogoriaProdutoRepository catogoriaProdutoRepository;

    @GetMapping()
    public List<Categoria> getTodosCategoria() {
        return CatogoriaProdutoRepository.obterTodos();
    }

    @PostMapping()
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return catogoriaProdutoRepository.salvar(Categoria);
    }
}
