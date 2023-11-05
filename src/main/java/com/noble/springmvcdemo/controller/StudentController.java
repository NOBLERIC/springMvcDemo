package com.noble.springmvcdemo.controller;

import com.noble.springmvcdemo.repository.model.Student;
import com.noble.springmvcdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }

    //redirect to the student form with an instance of Student object
    @RequestMapping(path = "/student/add",method = RequestMethod.GET)
    public String createStudent(Model model){
        /* Student studentInstance=new Student(); */
        model.addAttribute("studentInstance",new Student());
        return "edit";
    }
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    public String saveStudent(Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    //retrieving all student using get method
    @GetMapping(path = "/students")
    public String getAllStudent(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "studentsList";
    }
}
