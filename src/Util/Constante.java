package Util;

import javax.swing.text.MaskFormatter;

public class Constante {

    public static final MaskFormatter DateMask = Util.setMascara("##/##/####");
    public static final MaskFormatter TelefoneMask = Util.setMascara("(##)####-####");
    public static final MaskFormatter CpfMask = Util.setMascara("###.###.###-##");
    public static final MaskFormatter CnpjMask = Util.setMascara("##.###.###/####-##");
    public static final MaskFormatter CepMask = Util.setMascara("#####-###");
}
