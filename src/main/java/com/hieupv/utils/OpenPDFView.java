package com.hieupv.utils;

import com.hieupv.entity.Subject;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class OpenPDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // List of users that will be displayed in the PDF
        List<Subject> subjectList = (List<Subject>) model.get("students");

        Font font = new Font(Font.HELVETICA, 18, Font.BOLDITALIC);
        Font fontBold = new Font(Font.HELVETICA, 18, Font.BOLD);

        /*
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

        */
        try {
            // creation of the document with a certain size and certain margins
//            document = new Document(PageSize.A4, 20, 20, 20, 20);

            // creating table and set the column width
            PdfPTable table = new PdfPTable(4);
            float widths[] = {3, 6, 3, 3};
            table.setWidths(widths);
            table.setHeaderRows(1);

            PdfPCell cell = new PdfPCell(new Phrase("#"));
            cell.setBackgroundColor(Color.CYAN);
            table.addCell(cell);

            // add cell of table - header cell
            cell = new PdfPCell(new Phrase("Name"));
            cell.setBackgroundColor(Color.CYAN);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Score"));
            cell.setBackgroundColor(Color.CYAN);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Process"));
            cell.setBackgroundColor(Color.CYAN);
            table.addCell(cell);

            Phrase ph;
            // looping the table cell for adding definition
            int i = 1;
            for (Subject subject : subjectList) {
//                cell = new PdfPCell();
//                ph = new Phrase(i++);
//                cell.addElement(ph);
                table.addCell(String.valueOf(i++));

//                cell = new PdfPCell();
//                ph = new Phrase(subject.getName());
//                cell.addElement(ph);
                table.addCell(subject.getName());

//                cell = new PdfPCell();
//                ph = new Phrase(subject.getScore());
//                cell.addElement(ph);
                table.addCell(String.valueOf(subject.getScore()));

//                cell = new PdfPCell();
//                ph = new Phrase(subject.getProcess());
//                cell.addElement(ph);
                table.addCell(String.valueOf(subject.getProcess()));
            }

            // write the all into a file and save it.
//            PdfWriter.getInstance(document, new FileOutputStream("EmployeeData.pdf"));
            document.add(table);
            System.out.println("Successfull");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}