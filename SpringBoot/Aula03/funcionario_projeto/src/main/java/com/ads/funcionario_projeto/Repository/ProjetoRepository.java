package com.ads.funcionario_projeto.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ads.funcionario_projeto.Model.*;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}