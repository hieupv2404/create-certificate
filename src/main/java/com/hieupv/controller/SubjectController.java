package com.hieupv.controller;

import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;
import com.hieupv.service.SubjectService;
import com.hieupv.controller.response.CertificateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String listSubject(Model theModel, HttpSession session) {
        Student student  = (Student) session.getAttribute("student");
        List< Subject > theSubjects = subjectService.getAllSubject(student);
        theModel.addAttribute("subjects", theSubjects);
        return "/subjects/list-subjects";
    }

    @GetMapping("/{id}/viewPDF")
    public ModelAndView viewPDF(@PathVariable Integer id) throws Exception{
        CertificateResponse certificateResponse = subjectService.createCertificateFromSubject(id);
        return new ModelAndView("viewPDF", "certificates", certificateResponse);
    }
}
