package com.example.springBootProject.service;

import com.example.springBootProject.Modles.Student;
import com.example.springBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);

    }

    public String deleteStudent(String id) {
         studentRepository.deleteById(id);
        return id+"is removed";
    }
}
