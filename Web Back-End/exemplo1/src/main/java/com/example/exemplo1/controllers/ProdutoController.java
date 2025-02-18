package com.example.exemplo1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.exemplo1.models.Produto;

@RestController
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty() || produto.getPreco() <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        produto.setId(counter.incrementAndGet());
        produtos.add(produto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
        return produtos;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                return new ResponseEntity<>(p, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                produtos.remove(p);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public AtomicLong getCounter() {
        return counter;
    }
}

