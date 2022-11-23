package com.ads.funcionario_projeto.Controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ads.funcionario_projeto.Repository.FuncionarioRepository;
import com.ads.funcionario_projeto.Model.Funcionario;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/funcionarios")
@AllArgsConstructor
public class FuncionarioController {
    
    private FuncionarioRepository funcionarioRepository;


    @GetMapping
    public List<Funcionario> getAllFuncionario() {
            return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario>  getFuncionarioById(@PathVariable("id") Long id) {
        return  funcionarioRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Funcionario create (@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }


    @PutMapping("/{id}")
    Optional<Object> update(@RequestBody Funcionario newFuncionario, @PathVariable Long id) {

    return funcionarioRepository.findById(id).
        map(funcionario -> {
            
            funcionario.setNome(newFuncionario.getNome());
            funcionario.setDataAdmissao(newFuncionario.getDataAdmissao());
            funcionario.setSalario(newFuncionario.getSalario());
            funcionario.setCelular(newFuncionario.getCelular());
            funcionario.setEmail(newFuncionario.getEmail());

            return funcionarioRepository.save(funcionario);
        });
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        funcionarioRepository.deleteById(id);
    }
}

