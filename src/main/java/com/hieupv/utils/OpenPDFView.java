package com.hieupv.utils;

import com.hieupv.controller.response.CertificateResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class OpenPDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("PDF Created!");
        // List of users that will be displayed in the PDF
        CertificateResponse certificateResponse = (CertificateResponse) model.get("certificates");

        Font font = new Font(Font.HELVETICA, 18, Font.BOLDITALIC);
        Font fontBold = new Font(Font.HELVETICA, 18, Font.BOLD);

        //add image
        String imageFile = "https://images.glints.com/unsafe/glints-dashboard.s3.amazonaws.com/company-logo/2bd2a080caf53b335dd5d4f3f89a5a1b.png";
//        ImageData data = ImageDataFactory.create(imageFile);
//        Image image = new Image(data);
        Image image = Image.getInstance(imageFile);
        image.scaleAbsolute(640, 271);
        image.setAlignment(Element.ALIGN_CENTER);
        document.add(image);

        // Create paragraph
        String nameSubject = "Subject: " + certificateResponse.getNameSubject();
        Paragraph paragraphNameSubject = new Paragraph(nameSubject, font);
        paragraphNameSubject.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraphNameSubject);

        String nameStudent = "Name: " + certificateResponse.getNameStudent();
        Paragraph paragraphNameStudent = new Paragraph(nameStudent, font);
        paragraphNameStudent.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraphNameStudent);

        String grade = "Grade: " + certificateResponse.getGrade();
        Paragraph paragraphGrade = new Paragraph(grade, font);
        paragraphGrade.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraphGrade);

        String dateOfDone = "Date: " +certificateResponse.getDateOfDone();
        Paragraph paragraphDateOfDone = new Paragraph(dateOfDone, font);
        paragraphDateOfDone.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraphDateOfDone);
    }
}