package com.red.alumni.pdf;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.red.alumni.pdf.cell.Component;
import com.red.alumni.pdf.cell.Label;
import com.red.alumni.pdf.cell.PdfImage;
import com.red.alumni.pdf.cell.Table;
import com.red.alumni.pdf.style.StyleConst;

public class Pdf {

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        String path = "D://test.pdf";
        List<Component> list = new ArrayList<Component>();
        list.add(new Label("测试文本", StyleConst.BIGTITLE, new Color(0, 0, 255), StyleConst.ALIGN_LEFT));
        list.add(new Label("测试文本", StyleConst.COMMONTITLE));
        list.add(new Label("测试文本", StyleConst.SMALTITLE));
        list.add(new Label("测试文本", StyleConst.CONTEXT));
        list.add(new PdfImage("d://aaa.png"));
        list.add(new PdfImage("d://aaa.png"));

        Label label0 = new Label("列1", StyleConst.ALIGN_RIGHT);
        Label label1 = new Label("列1");
        Label label2 = new Label("列1");
        Label label3 = new Label("列1");
        Label[][] contents = new Label[1][4];
        contents[0][0] = label0;
        contents[0][1] = label1;
        contents[0][2] = label2;
        contents[0][3] = label3;
        Table table = new Table(4, new Label("测试表头", StyleConst.COMMONTITLE, new Color(0, 0, 255), StyleConst.ALIGN_LEFT), contents, 1);
        list.add(table);

        Label label00 = new Label("列1", StyleConst.BIGTITLE);
        Label label01 = new Label("列2");
        Label label02 = new Label("列3");
        Label label03 = new Label("列4");
        Label label04 = new Label("值1", StyleConst.BIGCONTEXT, StyleConst.ALIGN_RIGHT);
        Label label05 = new Label("值2");
        Label label06 = new Label("值3");
        Label label07 = new Label("值4");
        Label[][] contents1 = new Label[2][4];
        contents1[0][0] = label00;
        contents1[0][1] = label01;
        contents1[0][2] = label02;
        contents1[0][3] = label03;
        contents1[1][0] = label04;
        contents1[1][1] = label05;
        contents1[1][2] = label06;
        contents1[1][3] = label07;

        Table table1 = new Table(4, new Label("测试表头", StyleConst.COMMONTITLE), contents1, new float[] {60, 100, 100, 40}, 0);
        list.add(table1);

        Label l00 = new Label("标题", StyleConst.BIGTITLE, 5, 1, StyleConst.ALIGN_RIGHT);
        // Label l01 = new Label("");
        // Label l02 = new Label("");
        // Label l03 = new Label("");
        // Label l04 = new Label("");
        Label l05 = new Label("值5");
        Label[][] contents2 = new Label[4][3];
        contents2[0][0] = l00;
        contents2[0][1] = null;
        contents2[0][2] = null;
        contents2[1][0] = null;
        contents2[1][1] = null;
        contents2[1][2] = l05;
        contents2[2][0] = l05;
        contents2[2][1] = l05;
        contents2[2][2] = l05;
        contents2[3][0] = l05;
        contents2[3][1] = l05;

        Table table2 = new Table(3, contents2, new float[] {200, 100, 100}, 1);

        list.add(table2);
        build(list, path);
    }
}
