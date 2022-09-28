package com.ex1_springboot.tarefa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex1_springboot.tarefa.Model.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}

