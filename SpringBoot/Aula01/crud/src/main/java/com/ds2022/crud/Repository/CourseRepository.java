package com.ds2022.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds2022.crud.Model.Course;

@Repository //Faz gravações e manipulação de dados do Banco de Dados
public interface CourseRepository extends JpaRepository<Course, Long>{
    
}