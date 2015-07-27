package com.red.alumni.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.red.alumni.pdf.cell.Component;

public class PdfUtil {
    public static void build(List<Component> components, String path) {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            for (Component component : components) {
                PdfPTable pdfPTable = component.build();
                document.add(pdfPTable);
            }
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void build(List<Component> components, OutputStream stream) {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, stream);
            document.open();
            for (Component component : components) {
                PdfPTable pdfPTable = component.build();
                document.add(pdfPTable);
            }
            document.close();
            // response.flushBuffer();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
