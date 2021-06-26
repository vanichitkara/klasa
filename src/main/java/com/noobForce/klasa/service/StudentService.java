package com.noobForce.klasa.service;

import com.noobForce.klasa.model.Discussion;
import com.noobForce.klasa.model.Student;
import com.noobForce.klasa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.noobForce.klasa.exceptions.StudentNotFoundException;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    
    public Student addStudent(Student student)
    {
        // =============================================**README**===================================================
        // will have to send an additional parameter of loggedIn in the js file (as true or else set it true here).
        // first check in the js weather an account exists with that email (might have to create a controller)
        // if not, create a new account
        student.setLoggedIn(true);
        return studentRepository.save(student);
    }
    
    public Student findStudent(Long id)
    {
        return studentRepository
                .findById(id).orElseThrow( () ->
                        new StudentNotFoundException("Student with id: " + id.toString() + " was not found"));
        
    }
    
    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }
    
    public Student signInStudent(String email, String password)
    {
        Student student = studentRepository.findByEmailAndPassword(email, password).get(0);
        
        //debug
        student.setLoggedIn(false);
        System.out.println(student);
        student.setLoggedIn(true);
        System.out.println(student);
        
        return updateStudent(student);
    }
    
    
    public Student signOutStudent(String email, String password)
    {
        Student student = studentRepository.findByEmailAndPassword(email, password).get(0);
        student.setLoggedIn(false);
        return updateStudent(student);
    }
    
    public Boolean checkCredentials(String email, String password)
    {
        List<Student> studentAccount = studentRepository.findByEmailAndPassword(email, password);
        return studentAccount.size() > 0;
    }
    
    
    public Boolean isRegistered(String email)
    {
        List<Student> studentAccount = studentRepository.findByEmail(email);
        return studentAccount.size() > 0;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    /*public Student findLoggedInStudent()
    {
        return studentRepository.findStudentByIsLoggedIn(true).get(0);
    }*/
}

