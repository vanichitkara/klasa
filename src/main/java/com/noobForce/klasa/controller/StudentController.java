package com.noobForce.klasa.controller;


import com.noobForce.klasa.model.Discussion;
import com.noobForce.klasa.model.Student;
import com.noobForce.klasa.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
    private final StudentService studentService;
    
    public StudentController(StudentService studentServic)
    {
        this.studentService = studentServic;
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id)
    {
        return new ResponseEntity<>(studentService.findStudent(id), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        System.out.println("requested");
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }
    
    @GetMapping("/checkCredentials/{email}/{password}")
    public ResponseEntity<Boolean> hasAccount(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity<>(studentService.checkCredentials(email, password), HttpStatus.OK);
    }
    
    @GetMapping("isRegistered/{email}")
    public ResponseEntity<Boolean> isRegistered(@PathVariable String email)
    {
        return new ResponseEntity<>(studentService.isRegistered(email), HttpStatus.OK);
    }
    
    @GetMapping("/signin/{email}/{password}")
    public ResponseEntity<Student> signInStudent(@PathVariable String email, @PathVariable String password)
    {
        System.out.println("request reached");
        return new ResponseEntity<>(studentService.signInStudent(email, password), HttpStatus.OK);
    }
    
    @PutMapping("signout/{email}/{password}")
    public ResponseEntity<Student> signOutStudent(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity<>(studentService.signOutStudent(email, password), HttpStatus.OK);
    }

    @GetMapping("/getAllStudents")
    public List<Student> showStudents() {
        return studentService.getAllStudents();
    }
    
    /*@GetMapping("findLoggedIn")
    public ResponseEntity<Student> findLoggedInStudent()
    {
        return new ResponseEntity<>(studentService.findLoggedInStudent(), HttpStatus.OK);
    }*/
}
