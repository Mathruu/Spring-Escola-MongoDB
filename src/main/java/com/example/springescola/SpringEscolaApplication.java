package com.example.springescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springescola.model.Aluno;
import com.example.springescola.model.ContagemAlunosCurso;
import com.example.springescola.model.Disciplina;
import com.example.springescola.model.Notas;
import com.example.springescola.repository.AlunoRepository;
import com.example.springescola.repository.DisciplinaRepository;
import com.example.springescola.repository.NotasRepository;

@SpringBootApplication
public class SpringEscolaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringEscolaApplication.class, args);
	}

	@Autowired
	private AlunoRepository alun;

	@Autowired
	private DisciplinaRepository disc;

	@Autowired
	private NotasRepository not;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("####### Started");


		Aluno alu1 = new Aluno("1", "João", 17, "Letras");
		alun.save(alu1);

		Aluno alu2 = new Aluno("2", "Maria", 18, "Letras");
		alun.save(alu2);

		Aluno alu3 = new Aluno("3", "Marcos", 20,"Psicologia");
		alun.save(alu3);

		Aluno alu4 = new Aluno("4", "Ana", 19, "Psicologia");
		alun.save(alu4);

		Disciplina disc1 = new Disciplina(1, "Matemática");
		disc.save(disc1);

		Disciplina disc2 = new Disciplina(2, "Português");
		disc.save(disc2);

		Disciplina disc3 = new Disciplina(3, "História");	
		disc.save(disc3);

		Disciplina disc4 = new Disciplina(4, "Geografia");
		disc.save(disc4);
		
		Notas nota1 = new Notas("1", alu1, disc1, 8.0);
		not.save(nota1);

		Notas nota2 = new Notas("2", alu1, disc2, 7.0);
		not.save(nota2);

		Notas nota3 = new Notas("3", alu1, disc3, 9.0);
		not.save(nota3);

		Notas nota4 = new Notas("4", alu1, disc4, 10.0);
		not.save(nota4);

		Notas nota5 = new Notas("5", alu2, disc1, 8.0);
		not.save(nota5);

		Notas nota6 = new Notas("6", alu2, disc2, 4.0);
		not.save(nota6);

		Notas nota7 = new Notas("7", alu2, disc3, 5.0);
		not.save(nota7);

		Notas nota8 = new Notas("8", alu2, disc4, 9.0);
		not.save(nota8);

		Notas nota9 = new Notas("9", alu3, disc1, 1.0);
		not.save(nota9);

		Notas nota10 = new Notas("10", alu3, disc2, 10.0);
		not.save(nota10);

		Notas nota11 = new Notas("11", alu3, disc3, 7.0);
		not.save(nota11);

		Notas nota12 = new Notas("12", alu3, disc4, 8.0);
		not.save(nota12);

		Notas nota13 = new Notas("13", alu4, disc1, 9.0);
		not.save(nota13);

		Notas nota14 = new Notas("14", alu4, disc2, 10.0);
		not.save(nota14);

		Notas nota15 = new Notas("15", alu4, disc3, 8.0);
		not.save(nota15);

		Notas nota16 = new Notas("16", alu4, disc4, 7.0);
		not.save(nota16);


		List<Notas> lista1 = not.buscarNotasPorNomeAluno("Marcos");
		System.out.println("####### Lista de notas do aluno: ");
		for (Notas notas : lista1) {
			System.out.println("Nome: " + notas.getAlunoId().getNome());
			System.out.println("Disciplina: " + notas.getDisciplina().getNome());
			System.out.println("Nota: " + notas.getNota());
			System.out.println("Curso: " + notas.getAlunoId().getCurso());
			System.out.println("--------------------");
		}

		Aluno alunoMaiorMedia = not.buscarAlunoComMaiorMedia();
		System.out.println("####### Aluno com maior média: ");
		System.out.println("Nome: " + alunoMaiorMedia.getNome());
		System.out.println("--------------------");

		List<Aluno> lista3 = alun.buscarAlunosMaioresDeIdade(18);
		System.out.println("####### Lista de alunos maiores de idade: ");
		for (Aluno aluno : lista3) {
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("--------------------");
		}

		List<ContagemAlunosCurso> lista4 = alun.contarAlunosPorCurso();
		System.out.println("####### Contagem de alunos por curso: ");
		for (ContagemAlunosCurso contagemAlunosCurso : lista4) {
			System.out.println("Curso: " + contagemAlunosCurso.getCurso());
			System.out.println("Quantidade: " + contagemAlunosCurso.getTotalAlunos());
			System.out.println("--------------------");
		}


}
}
