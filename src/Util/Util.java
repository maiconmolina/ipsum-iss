package Util;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public static boolean ValidateCpf(String cpf) {
        /* Retirado de http://www.vivaolinux.com.br/script/Codigo-Java-para-validar-CPF */
        if (cpf == null) {
            return false;
        }
        cpf = cpf.replace(".", "").replace("-", "");
        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException ex) {
            return false;
        }

        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < cpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(cpf.substring(nCount - 1, nCount)).intValue();

            d1 = d1 + (11 - nCount) * digitoCPF;

            d2 = d2 + (12 - nCount) * digitoCPF;
        };

        resto = (d1 % 11);

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        resto = (d2 % 11);

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        String nDigVerific = cpf.substring(cpf.length() - 2, cpf.length());

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        return nDigVerific.equals(nDigResult);
    }

    public static boolean ValidateCnpj(String cnpj) {
        // Implementa isso aqui Lucas;
        cnpj = cnpj.replace(".", "").replace("-", "").replace("/", "");
        try {
            Long.parseLong(cnpj);
        } catch (NumberFormatException ex) {
            return false;
        }
        //Validação começa aqui!
        return false;
    }

    public static GregorianCalendar StringToGregorian(String date) {
        if (date == null) {
            return null;
        }
        date = date.replace("/", "").trim();
        if (date.equals("") || date.length() != 8) {
            return null;
        }
        int dia = Integer.parseInt(date.substring(0, 2));
        int mes = Integer.parseInt(date.substring(2, 4));
        int ano = Integer.parseInt(date.substring(4, 8));

        GregorianCalendar gc = new GregorianCalendar();
        gc.setLenient(false);
        gc.set(Calendar.DAY_OF_MONTH, dia);
        gc.set(Calendar.MONTH, mes);
        gc.set(Calendar.YEAR, ano);
        try {
            gc.getTime();
        } catch (IllegalArgumentException ex) {
            return null;
        }
        return gc;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return true;
        }
        for (Character c : str.toCharArray()) {
            try {
                Integer.parseInt(c.toString());
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
