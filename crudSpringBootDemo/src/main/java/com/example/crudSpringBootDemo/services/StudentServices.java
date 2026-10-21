package com.example.crudSpringBootDemo.services;

import com.example.crudSpringBootDemo.entities.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    private StudentRepository studentRepository;
    public StudentServices(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
     public Student createStudent(Student student){
        Student studentRes=studentRepository.save(student);
         return  studentRes;
     }

     public Student getStudent(Long id){
        Optional<Student> studentRes=studentRepository.findById(id);
        if(studentRes.isPresent()){
            return studentRes.get();
        }else {
            return  null;
        }

     }
     public List<Student> getAllStudent(){
        List<Student> studentList=studentRepository.findAll();

            return studentList;

     }

     public Student updateStudent(Long id,Student student){
        Optional<Student> studentToUpdate=studentRepository.findById(id);
        if(studentToUpdate.isPresent()){
            Student existingStudent=studentToUpdate.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setAge(student.getAge());
            existingStudent.setSubject(student.getSubject());
            existingStudent.setRollNo(student.getRollNo());
            return  studentRepository.save(existingStudent);
        }else{
            return  null;
        }
     }

    public Boolean deleteStudent(Long id){
        if(!studentRepository.existsById(id))
        {
            return  false;
        }else{
            studentRepository.deleteById(id);
            return  true;
        }
    }
}
