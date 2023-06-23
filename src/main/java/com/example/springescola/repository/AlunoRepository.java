package com.example.springescola.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springescola.model.Aluno;
import com.example.springescola.model.ContagemAlunosCurso;


public interface AlunoRepository  extends MongoRepository<Aluno, String>{
    // Buscar todas alunos maiores de idade.
    @Query("{ idade: { $gte: ?0 } }")
    List<Aluno> buscarAlunosMaioresDeIdade(int idadeMinima);

    //Obter a contagem total de alunos por curso. 
    @Aggregation(pipeline = {
        "{$group: {_id: '$curso', totalAlunos: {$sum: 1}}}"
    })
    List<ContagemAlunosCurso> contarAlunosPorCurso();
}
