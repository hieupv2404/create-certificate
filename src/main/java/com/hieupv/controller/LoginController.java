package com.hieupv.controller;

import com.hieupv.entity.Student;
import com.hieupv.service.StudentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new Student());
        return "login/login";
    }

    @SneakyThrows
    @PostMapping("/processLogin")
    public String processLogin(Model model, @ModelAttribute("loginForm") @Validated Student studentRequest, BindingResult result, HttpSession session) throws Exception {
        if(result.hasErrors()){
            return "login/login";
        }
        Student student = new Student();
        try {
            student = studentService.findStudentByUsernameAndPassword(studentRequest.getUsername(), studentRequest.getPassword());
        } catch (Exception e) {
            return "redirect:/login";
        }
        session.setAttribute("student", student);
        return "redirect:/api/subjects";


    }


}
