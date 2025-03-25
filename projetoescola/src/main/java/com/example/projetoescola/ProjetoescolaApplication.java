package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.CategoriaCurso;
import com.example.projetoescola.models.Curso;
import com.example.projetoescola.models.Pessoa;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired CursoRepository cursoRepository,
			@Autowired CategoriaCursoRepository categoriaRepository,
			@Autowired PessoaRepository pessoaRepository) {
		return args -> {
			cursoRepository.save(
					new Curso(null, "teste", 2000));
			cursoRepository.save(
					new Curso(null, "teste2", 2050));
			List<Curso> listaCursos = cursoRepository.findAll();
			System.out.println("*** Cursos cadastrados:");
			listaCursos.forEach(System.out::println);

			System.out.println("*** OBTER CURSO POR NOME:");
			List<Curso> cursos = cursoRepository.findByNome("teste2");
			cursos.forEach(System.out::println);

			System.out.println("*** Inserir Categoria:");
			CategoriaCurso categ = categoriaRepository.save(
					new CategoriaCurso(null, "Informática"));

			System.out.println("*** Vincular Categoria ao curso ***");
			Curso curso = cursoRepository.findAll().get(0);
			curso.setCategoriaCurso(categ);
			cursoRepository.save(curso);

			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa = pessoaRepository.salvar(
					new Pessoa(null, "João"));

			System.out.println("*** Criar pessoa ***");
			Pessoa pessoa2 = pessoaRepository.salvar(
					new Pessoa(null, "maria"));

			System.out.println("*** Vincular pessoa ao curso ***");
			curso.addPessoa(pessoa);
			curso.addPessoa(pessoa2);

			cursoRepository.save(curso);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}