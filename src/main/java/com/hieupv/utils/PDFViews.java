package com.hieupv.utils;

import com.hieupv.controller.response.CertificateResponse;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PDFViews extends NetJSAbstractViewPDF {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // List of certificateResponse that will be displayed in the PDF
        CertificateResponse certificateResponse = (CertificateResponse) model.get("certificates");
        // Create table with 3 columns of similar length
        Table table = new Table(new float[]{4, 4, 4});
        table.setWidth(UnitValue.createPercentValue(100));
        PdfFont bold = PdfFontFactory.createFont("Times-Bold");
        // adding header
        table.addHeaderCell(new Cell().add(new Paragraph("Name").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Student").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Grade").setFont(bold)));
        table.addHeaderCell(new Cell().add(new Paragraph("Date Of Done").setFont(bold)));
        // adding rows
            table.addCell(certificateResponse.getNameSubject());
            table.addCell(certificateResponse.getNameStudent());
            table.addCell(certificateResponse.getGrade());
            table.addCell(certificateResponse.getDateOfDone());

        document.add(table);
    }
}
