package com.ex_springboot.crud.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuncionario;

    @Column(length = 120, nullable = false)
    private String nome;
    
    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String celular;

    @Column(length = 60, nullable = false)
    private String cargo;

    @Column(columnDefinition = "decimal(10,2)", nullable = false)
    private Double salario;

    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    
}
