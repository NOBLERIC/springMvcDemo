package com.noble.springmvcdemo.service;

import com.noble.springmvcdemo.repository.StudentRepository;
import com.noble.springmvcdemo.repository.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    //Constructor based dependency injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //logger to help troubleshooting
    private Logger logger= LoggerFactory.getLogger(StudentService.class);

    //creating a new student
    public void saveStudent(Student student){
        try {
            studentRepository.save(student);
            logger.info(student.getName()+" student created successfully!");
        } catch (Exception e) {
            logger.error("Error while creating student!");
            throw new RuntimeException(e);
        }
    }
    public List<Student> getAllStudents(){
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            logger.error("\nError while retrieving students!\n");
            throw new RuntimeException(e);
        }
    }
}
