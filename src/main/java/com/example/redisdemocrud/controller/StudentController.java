package com.example.redisdemocrud.controller;

import com.example.redisdemocrud.entity.Student;
import com.example.redisdemocrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentRepository.save(student));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok().body(studentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id){
        return ResponseEntity.ok().body(studentRepository.findStudentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateById(@PathVariable int id,@RequestBody Student student){
        return ResponseEntity.ok().body(studentRepository.updateById(student,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return ResponseEntity.ok().body(studentRepository.deleteById(id));
    }
    @GetMapping("marks/{mark}")
    public ResponseEntity<List<Student>> getStudentByMarksGreater(@PathVariable float mark){
        return ResponseEntity.ok().body(studentRepository.findAllByMarksGreater(mark));
    }
}
