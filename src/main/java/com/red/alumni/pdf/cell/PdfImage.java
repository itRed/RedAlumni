package com.red.alumni.pdf.cell;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfImage extends Component {

    private String url;

    public PdfImage() {
        // TODO Auto-generated constructor stub
    }

    public PdfImage(String url ) {
        this.url = url;
    }

    public PdfImage(String url, int align ) {
        this.url = url;
        this.align = align;
    }

    public PdfImage(String url, int align, float spaceafter ) {
        this.url = url;
        this.align = align;
        this.spaceafter = spaceafter;
    }

    public PdfImage(String url, int align, int border ) {
        this.url = url;
        this.align = align;
        this.border = border;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBeforeSpace(float spaceafter) {
        this.spaceafter = spaceafter;
    }

    public PdfPTable build() {
        // TODO Auto-generated method stub
        try {
            PdfPTable table = new PdfPTable(column);
            PdfPCell cell = new PdfPCell();
            cell.setBorder(border);
            cell.setColspan(column);
            Image image = Image.getInstance(url);
            cell.setImage(image);
            table.addCell(cell);
            table.setSpacingBefore(spaceafter);
            return table;
        } catch (BadElementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
