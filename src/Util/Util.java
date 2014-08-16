package Util;

import javax.swing.text.MaskFormatter;

public class Util {
    public static MaskFormatter setMascara(String mascara) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(mascara);
        } catch (java.text.ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return mask;
    }
}
