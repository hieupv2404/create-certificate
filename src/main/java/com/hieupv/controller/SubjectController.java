package com.hieupv.controller;

import com.hieupv.controller.response.CertificateResponse;
import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;
import com.hieupv.service.SubjectService;
import com.hieupv.utils.Constant;
import com.itextpdf.html2pdf.HtmlConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String listSubject(Model theModel, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        List<Subject> theSubjects = subjectService.getAllSubject(student);
        theModel.addAttribute("subjects", theSubjects);
        return "/subjects/list-subjects";
    }

    @GetMapping("/{id}/viewPDF")
    public ModelAndView viewPDF(@PathVariable Integer id) throws Exception {
        CertificateResponse certificateResponse = subjectService.createCertificateFromSubject(id);
        return new ModelAndView("viewPDF", "certificates", certificateResponse);
    }

    @GetMapping("/{id}/viewCertificate")
    public String createCertificate(Model model, @PathVariable Integer id) throws Exception {
        CertificateResponse certificateResponse = subjectService.createCertificateFromSubject(id);
        List<CertificateResponse> certificateResponseList = new ArrayList<>();
        certificateResponse.setId(id);
        certificateResponseList.add(certificateResponse);
        model.addAttribute("certificates", certificateResponseList);
        return "certificates/certificate";
    }

    @GetMapping("/{id}/downloadPDF")
    public String downloadCertificate(@PathVariable Integer id) throws Exception {
        String url = Constant.SERVER + "/api/subjects/" + id + "/viewCertificate";
        Document doc = Jsoup.connect(url).get();
        doc.select("div.download-btn").remove();
        File file = new File("C:/create-certificate/resources/image/");
        if (!file.exists()) {
            file.mkdirs();
        }
        Path target = Paths.get("C:/create-certificate/resources/image/2bd2a080caf53b335dd5d4f3f89a5a1b.png");
        URL website = new URL("https://images.glints.com/unsafe/glints-dashboard.s3.amazonaws.com/company-logo/2bd2a080caf53b335dd5d4f3f89a5a1b.png");
        try (InputStream in = website.openStream()) {
            Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
        }
        doc.getElementById("logo-url")
                .attr("src", "C:/create-certificate/resources/image/2bd2a080caf53b335dd5d4f3f89a5a1b.png");
        HtmlConverter.convertToPdf(doc.html(), new
                FileOutputStream(Constant.PATH_CREATE_PDF + "string-to-pdf.pdf"));

        System.out.println("PDF Created!");
        return "redirect:/api/subjects/" + id + "/viewCertificate";
    }
}
