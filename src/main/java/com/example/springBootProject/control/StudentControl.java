package com.example.springBootProject.control;

import com.example.springBootProject.Modles.Student;
import com.example.springBootProject.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentControl {
    Logger logger = LoggerFactory.getLogger(StudentControl.class);
    @Autowired
    private StudentService studentService;

    /*@GetMapping("/all")
    public List<Student> getAllStudent (){
        return studentService.getAllStudent();
    }

     */

    @GetMapping("/all")
    public ResponseEntity<List<Student>>getAllStudent(){
        try{
            logger.info("successfull get all student details");
            return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("unsuccessfull get all student details");

            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        try{
            logger.info("successfull create student");

            return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
        }catch (Exception e){
            logger.info("unsuccessfull create student");
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    /*@GetMapping("/{id}")
    public Student getStudentById (@PathVariable String id){
      return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
   */
    /*
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable String id){
         studentService.deleteStudent(id);
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteStudentById(@PathVariable String id){
        try {
            logger.info("successfull delete student by id");
            return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
        }catch (Exception e){
            logger.info("successfull delete student by id");
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>>getStudentById(@PathVariable String id) {
        try {
            logger.info("successfull get student by id");
            return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.CREATED);

        }catch (Exception e){
            logger.info("unsuccessfull get student by id");

            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
