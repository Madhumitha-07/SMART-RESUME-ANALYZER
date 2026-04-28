package com.resume.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class ResumeService {

    public String analyze(MultipartFile file) {
        try {
            InputStream input = file.getInputStream();
            PDDocument document = PDDocument.load(input);

            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            document.close();

            int score = calculateScore(text);

            return "Resume Score: " + score + "%";

        } catch (Exception e) {
            return "Error processing file";
        }
    }

    private int calculateScore(String text) {
        int score = 0;

        if (text.contains("Java")) score += 20;
        if (text.contains("Spring")) score += 20;
        if (text.contains("SQL")) score += 20;
        if (text.contains("HTML")) score += 20;
        if (text.contains("CSS")) score += 20;

        return score;
    }
}
