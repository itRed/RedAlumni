package com.red.alumni.pdf.cell;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.red.alumni.pdf.style.StyleConst;

public class Table extends Component {

    private Label title;
    private Label[][] contents;
    private float[] colunmwidth;

    public Table() {
        // TODO Auto-generated constructor stub
    }

    public Table(int colunm, Label[][] contents, int border ) {
        this.column = colunm;
        this.contents = contents;
        this.border = border;
    }

    public Table(int colunm, Label title, Label[][] contents, int border ) {
        this.column = colunm;
        this.title = title;
        this.contents = contents;
        this.border = border;
    }

    public Table(int colunm, Label[][] contents, float[] colunmwidth, int border ) {
        this.column = colunm;
        this.contents = contents;
        this.colunmwidth = colunmwidth;
        this.border = border;
    }

    public Table(int colunm, Label[][] contents, float[] colunmwidth, int border, int align ) {
        this.column = colunm;
        this.contents = contents;
        this.colunmwidth = colunmwidth;
        this.border = border;
        this.align = align;
    }

    public Table(int colunm, Label title, Label[][] contents, float[] colunmwidth, int border ) {
        this.column = colunm;
        this.title = title;
        this.contents = contents;
        this.colunmwidth = colunmwidth;
        this.border = border;
    }

    public Table(int colunm, Label title, Label[][] contents, float[] colunmwidth, int border, int align ) {
        this.column = colunm;
        this.title = title;
        this.contents = contents;
        this.colunmwidth = colunmwidth;
        this.border = border;
        this.align = align;
    }

    public void setBeforeSpace(float spaceafter) {
        this.spaceafter = spaceafter;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public Label[][] getContents() {
        return contents;
    }

    public void setContents(Label[][] contents) {
        this.contents = contents;
    }

    public float[] getColunmwidth() {
        return colunmwidth;
    }

    public void setColunmwidth(float[] colunmwidth) {
        this.colunmwidth = colunmwidth;
    }

    public PdfPTable build() {
        // TODO Auto-generated method stub
        PdfPTable table = new PdfPTable(column);
        table.setHorizontalAlignment(align);
        try {
            Rectangle rect = new Rectangle(523, 770);
            if (null != colunmwidth) table.setWidthPercentage(colunmwidth, rect);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (null != title) {
            PdfPCell cell = new PdfPCell();
            Paragraph paragraph = new Paragraph(title.getText(), title.getFont());
            paragraph.setAlignment(title.getAlign());
            cell.setBackgroundColor(new BaseColor(title.getColor()));
            cell.setPaddingBottom(10);
            cell.setBorder(title.getBorder());
            cell.setColspan(column);
            cell.addElement(paragraph);
            table.addCell(cell);
        }
        for (int i = 0; i < contents.length; i++) {
            Label[] innerlabel = contents[i];
            for (int j = 0; j < innerlabel.length; j++) {
                Label label = innerlabel[j];
                PdfPCell cell = new PdfPCell();
                if (null != label) {
                    Paragraph paragraph = new Paragraph(label.getText(), label.getFont());
                    paragraph.setAlignment(label.getAlign());
                    cell.setRowspan(label.getRowspan());
                    cell.setColspan(label.getColspan());
                    cell.addElement(paragraph);
                } else {
                    Paragraph paragraph = new Paragraph("", StyleConst.SMALTITLE);
                    cell.addElement(paragraph);
                }
                cell.setBorderWidth(border);

                table.addCell(cell);
            }
        }
        table.setSpacingBefore(spaceafter);
        return table;
    }
}
