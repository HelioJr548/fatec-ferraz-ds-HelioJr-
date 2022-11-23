package com.ads.funcionario_projeto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ads.funcionario_projeto.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByEmail(String email);
}
