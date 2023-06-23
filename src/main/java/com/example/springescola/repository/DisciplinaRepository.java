package com.example.springescola.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springescola.model.Disciplina;


public interface DisciplinaRepository extends MongoRepository<Disciplina, Integer> {
}
