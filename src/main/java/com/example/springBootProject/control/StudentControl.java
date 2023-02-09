package com.example.springBootProject.control;

import com.example.springBootProject.Modles.Student;
import com.example.springBootProject.payload.Studentresponce;
import com.example.springBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControl {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent (){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById (@PathVariable String id){
      return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id){
         studentService.deleteStudent(id);
    }

    /*@GetMapping("/id")
    public ResponseEntity<Studentresponce>getStudentById(@PathVariable String id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.CREATED);
    }
*/
}
