package com.resume.controller;

import com.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping("/analyze")
    public String analyzeResume(@RequestParam("file") MultipartFile file) {
        return service.analyze(file);
    }
}
