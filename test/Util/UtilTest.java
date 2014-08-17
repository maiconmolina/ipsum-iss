/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.text.MaskFormatter;
import junit.framework.TestCase;

/**
 *
 * @author Usuario
 */
public class UtilTest extends TestCase {

    public UtilTest(String testName) {
        super(testName);
    }

    public void testValidateCpfTrue() {
        System.out.println("ValidateCpfTrue");
        String cpf = "068.692.315-40";
        assertTrue("O CPF é válido. No entanto, a rotina de validação acusa"
                + " ser inválido.", Util.ValidateCpf(cpf));
    }

    public void testValidateCpfFalse() {
        System.out.println("ValidateCpfFalse");
        String cpf = "068.692.315-41";
        assertFalse("O CPF é inválido. No entanto, a rotina de validação acusa"
                + " ser válido.", Util.ValidateCpf(cpf));
    }

    public void testValidateCpfFalseString() {
        System.out.println("ValidateCpfFalseString");
        String cpf = "068.6a2.315-40";
        assertFalse("Caracteres não numéricos não devem ser permitidos.", Util.ValidateCpf(cpf));
    }

    public void testValidateCpfFalseNull() {
        System.out.println("ValidateCpfFalseNull");
        String cpf = null;
        assertFalse("Null não suportado.", Util.ValidateCpf(cpf));
    }
}
