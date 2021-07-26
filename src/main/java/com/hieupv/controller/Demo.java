package com.hieupv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@ControllerAdvice
public class Demo {
    @GetMapping("/demo")
    public String demo() {
        return "/demo/input";
    }

    @GetMapping(value = {"/result", "/result/{id}"})
    public String result(Model model, ModelMap modelMap, @RequestParam("usd") float usd, @PathVariable(required = false) Integer id) {
        float vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        model.addAttribute("id", id);
        return "/demo/result";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @PostMapping("/uploadFile")
    public String uploadFile(Model model, @RequestParam MultipartFile multipartFile){
        String filename = multipartFile.getOriginalFilename();
        File file = new File("../webapp/resources/image/", filename);
        try {
            multipartFile.transferTo(file);
            model.addAttribute("path", file.getAbsolutePath());
            model.addAttribute("result", "Successful");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("result", "Error");
        }
        return "/demo/upload";
    }
}
