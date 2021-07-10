package com.hieupv.controller;

import com.hieupv.entity.Student;
import com.hieupv.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listCustomers(Model theModel) {
        List< Student > theStudents = studentService.getAllStudent();
        theModel.addAttribute("students", theStudents);
        return "/students/list-students";
    }
}
