package com.red.alumni.pdf.cell;

import java.awt.Color;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.red.alumni.pdf.style.StyleConst;

public class Label extends Component {

    private String text;
    private Font font = StyleConst.CONTEXT;
    private Color color = new Color(255, 255, 255);
    private int rowspan = 1;
    private int colspan = 1;

    public Label() {
        // TODO Auto-generated constructor stub
    }

    public Label(String text ) {
        this.text = text;
        this.font = StyleConst.CONTEXT;
    }

    public Label(String text, int align ) {
        this.text = text;
        this.align = align;
    }

    public Label(String text, Font font ) {
        this.text = text;
        this.font = font;
    }

    public Label(String text, Font font, int rowspan, int colspan, int align ) {
        this.text = text;
        this.font = font;
        this.rowspan = rowspan;
        this.colspan = colspan;
        this.align = align;
    }

    public Label(String text, Font font, int align ) {
        this.text = text;
        this.font = font;
        this.align = align;
    }

    public Label(String text, Font font, Color color ) {
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public Label(String text, Font font, Color color, int align ) {
        this.text = text;
        this.font = font;
        this.color = color;
        this.align = align;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRowspan() {
        return rowspan;
    }

    public void setRowspan(int rowspan) {
        this.rowspan = rowspan;
    }

    public int getColspan() {
        return colspan;
    }

    public void setColspan(int colspan) {
        this.colspan = colspan;
    }

    public void setBeforeSpace(float spaceafter) {
        this.spaceafter = spaceafter;
    }

    public PdfPTable build() {
        // TODO Auto-generated method stub
        PdfPTable table = new PdfPTable(column);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(align);
        PdfPCell cell = new PdfPCell();
        cell.addElement(paragraph);
        cell.setBorder(border);
        cell.setBackgroundColor(new BaseColor(color));
        cell.setColspan(column);
        table.addCell(cell);
        table.setSpacingBefore(spaceafter);
        return table;
    }

}
