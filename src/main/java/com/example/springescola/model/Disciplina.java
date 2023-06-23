package com.example.springescola.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "disciplinas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Disciplina {
    
    @Id
    private int id;
    private String nome;
}
