package com.example.springescola.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.springescola.model.Aluno;
import com.example.springescola.model.Notas;

public interface NotasRepository extends MongoRepository<Notas, String> {
    
    //Buscar todas as notas de um determinado aluno pelo seu nome. 
    @Query("{'AlunoId.nome': ?0}")
    List<Notas> buscarNotasPorNomeAluno(String nomeAluno);

    //Buscar o aluno com a maior média de notas
    @Aggregation(pipeline = {
        "{$group: { _id: '$AlunoId', nome: { $first: '$AlunoId.nome' }, media: { $avg: '$nota' } }}",
        "{$sort: { media: -1 }}",
        "{$limit: 1}"
    })
    Aluno buscarAlunoComMaiorMedia();

}
