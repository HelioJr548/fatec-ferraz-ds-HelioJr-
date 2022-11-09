package com.etiqueta_tutorial.etiqueta_tutorial.Model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import com.etiqueta_tutorial.etiqueta_tutorial.Model.Tutorial;

@Entity
@Data
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etiqueta_generator")
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "etiquetas")
    @JsonIgnore
    private Set<Tutorial> tutorials = new HashSet<>(); 
}

/*
Usamos a anotação @ManyToMany para associação de muitos para muitos entre duas entidades: Tutorial e Etiqueta.

Todo relacionamento muitos-para-muitos tem dois lados:

O lado proprietário
O não-proprietário (lado inverso)
A entidade Tutorial é a proprietária do relacionamento e a entidade Etiquetaé o lado inverso.

A tabela de junção é especificada no lado proprietário (Tutorial) usando a anotação @JoinTable. Esse relacionamento é bidirecional, o lado inverso (Etiqueta) deve utilizar o elemento mappedBy para especificar o campo de relacionamento ou propriedade do lado proprietário.

Então, o lado que não tem o atributo mappedBy é o dono, o lado que tem o atributo mappedBy é o lado inverso.

O lado do proprietário é o lado que o Hibernate olha para saber qual associação existe. Por exemplo, se você adicionar uma Etiqueta no conjunto de etiquetas de um Tutorial, uma nova linha será inserida pelo Hibernate na tabela de junção (tutorial_etiqueta). Ao contrário, se você adicionar um Tutorial ao conjunto de tutoriais de uma Etiqueta, nada será modificado no banco de dados.

Definimos o @ManyToMany com FetchType.LAZY para o tipo de busca por ID.

@JsonIgnore é usado para ignorar a propriedade lógica usada na serialização e desserialização.
*/

