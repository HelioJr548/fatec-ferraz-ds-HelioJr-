package com.ads.funcionario_projeto.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ads.funcionario_projeto.Model.Projeto;
import com.ads.funcionario_projeto.Repository.FuncionarioRepository;
import com.ads.funcionario_projeto.Repository.ProjetoRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProjetoController {

    private FuncionarioRepository funcionarioRepository;

    private ProjetoRepository projetoRepository;

    @GetMapping("funcionarios/{funcioarioId}/projetos")
    public List<Projeto> getAllCommentsByFuncionarioId(@PathVariable(value = "funcionarioId") Long funcionarioId) {
        return projetoRepository.findByFuncionarioId(funcionarioId);
    }

    @GetMapping("/projetos/{id}")
    public Optional<Projeto> getProjetoById(@PathVariable("id") Long id) {
        return projetoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Projeto create (@RequestBody Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @PutMapping("/projetos/{id}")
    public Optional<Object> updateComment(@PathVariable("id") long id, @RequestBody Projeto newProjeto) {
        return projetoRepository.findById(id).map(projeto -> {
            projeto.setTitulo(newProjeto.getTitulo());
            projeto.setDescricao(newProjeto.getDescricao());
            projeto.setDataInicio(newProjeto.getDataInicio());
            projeto.setDataFim(newProjeto.getDataFim());
            projeto.setValorPrevisto(newProjeto.getValorPrevisto());
            projeto.setValorGasto(newProjeto.getValorGasto());

            return projetoRepository.save(projeto);
        });
    }

    @DeleteMapping("/projetos/{id}")
    public void delete(@PathVariable Long id) {
        projetoRepository.deleteById(id);
    }

    @DeleteMapping("/funcionarios/{funcionarioId}/projetos")
    public void deleteAllCommentsOfFuncionario(@PathVariable(value = "funcioanrioId") Long funcionarioId) {
        projetoRepository.deleteById(funcionarioId);
    }

}