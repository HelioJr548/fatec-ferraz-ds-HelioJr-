package com.ds2022.crud.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds2022.crud.Model.Course;

@Repository //Faz gravações e manipulação de dados do Banco de Dados
public interface CourseRepository extends JpaRepository<Course, Long>{
    List<Course> findByName(String name);
    List<Course> findByCategory(String category);
    List<Course> findByNameStartingWith(String prefix);
    List<Course> findByNameEndingWith(String suffix);
    List<Course> findByNameContaining(String infix);
    List<Course> findByIdBetween(Long startId, Long endId);
    List<Course> findByNameLike(String likePattern);
}