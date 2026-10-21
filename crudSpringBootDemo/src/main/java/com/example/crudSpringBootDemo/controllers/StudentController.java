package com.example.crudSpringBootDemo.controllers;

import com.example.crudSpringBootDemo.entities.Student;
import com.example.crudSpringBootDemo.services.StudentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentServices studentServices;
    public StudentController(StudentServices studentServices){
        this.studentServices=studentServices;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent=studentServices.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);

    }
    @GetMapping("/get/{id}")
    public  ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentRep=studentServices.getStudent(id);
        if(studentRep==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRep);

    }
    @GetMapping("/get")
    public  ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentRep=studentServices.getAllStudent();
        if(studentRep.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRep);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){

        Student studentRep=studentServices.updateStudent(id,student);
        if(studentRep==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRep);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       Boolean isDeleted= studentServices.deleteStudent(id);
       if(!isDeleted){
           return  ResponseEntity.notFound().build();
       }else{
           return ResponseEntity.ok("Record Deleted");
       }
    }


}
