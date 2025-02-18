package com.example.exemplo1.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplo1.dtos.CalculadoraRequestDTO;


@RestController
public class Calculadora {
    @GetMapping("/ola")
    public String getOlaMundo(@RequestParam("n")String nome, @RequestParam("t") String tipo) {
        return "Olá, " + tipo + " " + nome + "!";
    }
    
    @GetMapping("/cliente/{id}")
    public String getCliente(@PathVariable("id") int id) {
        return "Cliente - id: " + id;
    }
    @GetMapping("/soma")
    public int getsoma(@RequestParam ("n1") int n1, @RequestParam("n2") int n2) {
        return n1 + n2;
    }
    
    @GetMapping("/subtracao")
    public int getsubtracao(@RequestParam ("n1") int n1, @RequestParam("n2") int n2) {
        return n1 - n2;
    }
    @GetMapping("/multiplicar")
    public Double multiplicar (
    @RequestBody CalculadoraRequestDTO calc) {
return calc.getN1()  *  calc.getN2();
    }

    @GetMapping("/div")
    public int getdiv(@RequestParam ("n1") int n1, @RequestParam("n2") int n2) {
        return n1 / n2;
    }
@DeleteMapping("/deletar/{id}") 
public String deletar(@PathVariable("id") Long id) {
    return "Deletando o  id:  " + id;

    }

        }  