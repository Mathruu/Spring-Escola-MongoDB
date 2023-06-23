package com.example.springescola.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "contagemAlunosCurso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContagemAlunosCurso {

    @Id
    private String curso;
    @Field("totalAlunos")
    private int TotalAlunos;
}