package com.example.springBootProject.repository;

import com.example.springBootProject.Modles.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
