package com.red.alumni.pdf.cell;

import com.itextpdf.text.Element;

public abstract class Component implements PdfBuildImpl {

    protected int column = 1;
    protected int align = Element.ALIGN_CENTER;
    protected int border = 0;
    protected float spaceafter = 5;

    protected Component() {
        // TODO Auto-generated constructor stub
    }

    protected Component(int align, int border ) {
        this.align = align;
        this.border = border;
    }

    protected int getColumn() {
        return column;
    }

    protected void setColumn(int column) {
        this.column = column;
    }

    protected int getAlign() {
        return align;
    }

    protected void setAlign(int align) {
        this.align = align;
    }

    protected int getBorder() {
        return border;
    }

    protected void setBorder(int border) {
        this.border = border;
    }

    protected float getSpaceafter() {
        return spaceafter;
    }

    protected void setSpaceafter(float spaceafter) {
        this.spaceafter = spaceafter;
    }

}
