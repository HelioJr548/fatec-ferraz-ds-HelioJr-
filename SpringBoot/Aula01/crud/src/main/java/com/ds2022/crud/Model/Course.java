package com.ds2022.crud.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data //Anotação do LOMBOK, gerador de Getters e Setters
@Entity //Classe será mapeada para tabela
public class Course {
    
    @Id //Proxima coluna sera chave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //AutoIncremento
    private Long id;

    @Column(length = 200 , nullable = false) //Determina tamanho de caracteres do atributo 'name'  
    private String name;
    
    @Column(length = 200, nullable = false)
    private String category;
}


