package com.example.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.models.Categoria;
import com.example.app.repository.CategoriaProdutoRepository;

import main.java.com.example.app.models.Categoria;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping()
    public List<CategoriaProdutoRepository> getTodosCategoria() {
        return categoriaProdutoRepository.obterTodos();
    }

    @PostMapping()
    public Categoria postCategoria(@RequestBody Categoria categoria) {
        return catogoriaProdutoRepository.salvar(Categoria);
    }
}
