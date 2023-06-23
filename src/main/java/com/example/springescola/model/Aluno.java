package com.example.springescola.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Aluno {
    
    @Id
    private String id;
    private String nome;
    private Number idade;
    private String curso;
}
