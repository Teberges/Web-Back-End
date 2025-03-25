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
import com.example.projetoescola.models.Professor;
import com.example.projetoescola.repositories.CategoriaCursoRepository;
import com.example.projetoescola.repositories.CursoRepository;
import com.example.projetoescola.repositories.PessoaRepository;
import com.example.projetoescola.repositories.ProfessorRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

@Bean
public CommandLineRunner init(
@Autowired CursoRepository cursoRepository,
@Autowired CategoriaCursoRepository categoriaRepository,
@Autowired PessoaRepository pessoaRepository,
@Autowired ProfessorRepository professorRepository) {
return args -> {
cursoRepository.save(
new Curso(null, "teste", 2000));
cursoRepository.save(
new Curso(null, "teste2", 2050));
List<Curso> listaCursos = cursoRepository.findAll();
System.out.println("*** Cursos cadastrados:");
listaCursos.forEach(System.out::println);

System.out.println("***Obter curso por nome");
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

System.out.println("***Criar professores");
professorRepository.save(new Professor(null, "Ana Clara", 2000.00));
professorRepository.save(new Professor(null, "Pedrão", 3000.00));
professorRepository.save(new Professor(null, "Iago", 4000.00));
professorRepository.save(new Professor(null, "Arthur", 5000.00));
professorRepository.save(new Professor(null, "Erick", 6000.00));
professorRepository.save(new Professor(null, "Anna Julya", 7000.00));

System.out.println("*** Professores com salário maior que 3000 ***");
List<Professor> professoresSalarioMaior = professorRepository.findBySalarioGreaterThan(3000.0);
professoresSalarioMaior.forEach(System.out::println);

System.out.println("*** Professores com salário menor ou igual a 3000 ***");
List<Professor> professoresSalarioMenorIgual = professorRepository.findBySalarioLessThanEqual(3000.0);
professoresSalarioMenorIgual.forEach(System.out::println);

System.out.println("*** Professores cujo nome começa com 'A' ***");
List<Professor> professoresNomeComecaComA = professorRepository.findByNomeStartingWith("A");
professoresNomeComecaComA.forEach(System.out::println);

};
}

public static void main(String[] args) {
SpringApplication.run(ProjetoescolaApplication.class, args);
}

}