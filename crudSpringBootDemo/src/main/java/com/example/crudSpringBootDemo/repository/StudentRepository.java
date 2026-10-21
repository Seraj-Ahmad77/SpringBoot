package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
