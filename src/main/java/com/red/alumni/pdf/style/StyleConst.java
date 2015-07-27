package com.red.alumni.pdf.style;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;

public class StyleConst {

    /**
     * font
     */
    final public static Font BIGTITLE = new Font(getFont(), 30, Font.BOLD);
    final public static Font COMMONTITLE = new Font(getFont(), 16, Font.BOLD);
    final public static Font SMALTITLE = new Font(getFont(), 12, Font.BOLD);
    final public static Font BIGCONTEXT = new Font(getFont(), 16, Font.NORMAL);
    final public static Font CONTEXT = new Font(getFont(), 10, Font.NORMAL);
    final public static Font SMALLCONTEXT = new Font(getFont(), 9, Font.NORMAL);
    final public static Font TINYCONTEXT = new Font(getFont(), 7, Font.NORMAL);

    /**
     * 位置布局
     */
    final public static int ALIGN_MIDDLE = Element.ALIGN_CENTER;
    final public static int ALIGN_LEFT = Element.ALIGN_LEFT;
    final public static int ALIGN_RIGHT = Element.ALIGN_RIGHT;

    private static BaseFont getFont() {
        try {
            BaseFont chinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            return chinese;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
