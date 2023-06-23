package com.example.springescola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notas {

    @Id
    private String id;
    private Aluno AlunoId;
    private Disciplina disciplina;
    private Number nota;
    
}
