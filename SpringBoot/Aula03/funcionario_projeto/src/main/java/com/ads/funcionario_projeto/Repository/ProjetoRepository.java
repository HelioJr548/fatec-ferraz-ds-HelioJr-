package com.ads.funcionario_projeto.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ads.funcionario_projeto.Model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    Optional<Projeto> findById(Long id);

    @Transactional
    void deleteById(Long Id);

    List<Projeto> findByFuncionarioId(Long funcionarioId);
}
