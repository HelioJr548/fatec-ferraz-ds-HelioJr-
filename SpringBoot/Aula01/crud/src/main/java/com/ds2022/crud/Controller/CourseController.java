package com.ds2022.crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ds2022.crud.Model.Course;
import com.ds2022.crud.Repository.CourseRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@RestController     //Define a classe como Controller
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController {

    private CourseRepository courseRepository; 

    @GetMapping //Mapeia o get, para retornar os contedos da tabela 
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping("/name")
    public List<Course> listName(@RequestParam String name) {
        return courseRepository.findByName(name);
    }

    @GetMapping("/category")
    public List<Course> listCategory(@RequestParam String category) {
        return courseRepository.findByCategory(category);
    }

    @GetMapping("/prefix")
    public List<Course> listStarting(@RequestParam String prefix) {
        return courseRepository.findByNameStartingWith(prefix);
    }
    
    @GetMapping("/suffix")
    public List<Course> listEnding(@RequestParam String suffix) {
        return courseRepository.findByNameEndingWith(suffix);
    }

    @GetMapping("/infix")
    public List<Course> listContaining(@RequestParam String infix) {
        return courseRepository.findByNameContaining(infix);
    }
    
    @GetMapping("/like")
    public List<Course> listNameLike(@RequestParam String likePattern) {
        return courseRepository.findByNameLike(likePattern);
    }
    
    @GetMapping("/between")
    public List<Course> listIdBetween(@RequestParam(name="startId") Long startId, @RequestParam(name="endId") Long endId) {
        return courseRepository.findByIdBetween(startId, endId);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Course create (@RequestBody Course course) {
        return courseRepository.save(course);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    Optional<Object> update(@RequestBody Course newCourse, @PathVariable Long id) {

    return courseRepository.findById(id).
        map(course -> {
        course.setName(newCourse.getName());
        course.setCategory(newCourse.getCategory());
        return courseRepository.save(course);
        });
    }

    @GetMapping("/{id}")
    public Optional<Course> getId(@PathVariable Long id) {
        return courseRepository.findById(id);
    }

}
