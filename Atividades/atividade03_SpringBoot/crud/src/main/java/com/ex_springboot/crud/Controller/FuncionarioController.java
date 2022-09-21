package com.ex_springboot.crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ex_springboot.crud.Model.Funcionario;
import com.ex_springboot.crud.Repository.FuncionarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    
    public FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Funcionario create (@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/{idFuncionario}")
    public void delete(@PathVariable Long idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }

    @GetMapping("/{idFuncionario}")
    public Optional<Funcionario> getId(@PathVariable Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

}
