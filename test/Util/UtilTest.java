/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public void testStringToGregorian() {
        System.out.println("StringToGregorian");
        GregorianCalendar gc = new GregorianCalendar(1994, 9, 18);
        Calendar teste = Util.StringToCalendar("18/10/1994");
        assertEquals(gc.get(Calendar.DAY_OF_MONTH), teste.get(Calendar.DAY_OF_MONTH));
        assertEquals(gc.get(Calendar.MONTH), teste.get(Calendar.MONTH));
        assertEquals(gc.get(Calendar.YEAR), teste.get(Calendar.YEAR));
    }

    public void testStringToGregorianError() {
        System.out.println("StringToGregorianError");
        Calendar date = Util.StringToCalendar("32/08/2014");
        assertEquals(null, date);
    }
    
    public void testStringToGregorianVazio() {
        System.out.println("StringToGregorianVazio");
        Calendar date = Util.StringToCalendar("  /  /    ");
        assertEquals(null, date);
    }
    
    public void testIsNumericTrue(){
        System.out.println("IsNumericTrue");
        assertTrue(Util.isNumeric("104311334"));
    }
    
    public void testIsNumericFalse(){
        System.out.println("IsNumericFalse");
        assertFalse(Util.isNumeric("1043a1334"));
    }
    
    public void testIsNumericEmpty(){
        System.out.println("IsNumericEmpty");
        assertTrue(Util.isNumeric(""));
    }
    
    public void testIsNumericNull(){
        System.out.println("IsNumericNull");
        assertTrue(Util.isNumeric(null));
    }
    
    public void testValidateCnpjTrue(){
        System.out.println("ValidateCnpjTrue");
        String cnpj = "60.871.406/0001-71";
        assertTrue(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjFalse(){
        System.out.println("ValidateCnpjFalse");
        String cnpj = "60.871.406/0001-72";
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjNull(){
        System.out.println("ValidateCnpjNull");
        String cnpj = null;
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjEmpty(){
        System.out.println("ValidateCnpjEmpty");
        String cnpj = "";
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjCharacter(){
        System.out.println("ValidateCnpjCharacter");
        String cnpj = "asfgh";
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjEspaco(){
        System.out.println("ValidateCnpjEspaco");
        String cnpj = "  .   .   /    -  ";
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjTrueNoMask(){
        System.out.println("ValidateCnpjNoMask");
        String cnpj = "60871406000171";
        assertTrue(Util.ValidateCnpj(cnpj));
    }
    
    public void testValidateCnpjFalseNoMask(){
        System.out.println("ValidateCnpjNoMask");
        String cnpj = "60871406000172";
        assertFalse(Util.ValidateCnpj(cnpj));
    }
    
    public void testIsNullOrEmptyTrueNull(){
        System.out.println("IsNullOrEmptyTrueNull");
        assertTrue(Util.isNullOrEmpty(null));
    }
    
    public void testIsNullOrEmptyTrueEmpty(){
        System.out.println("IsNullOrEmptyTrueEmpty");
        assertTrue(Util.isNullOrEmpty(""));
    }
    
    public void testIsNullOrEmptyFalse(){
        System.out.println("IsNullOrEmptyFalse");
        assertFalse(Util.isNullOrEmpty("Teste"));
    }
    
    public void testCalendarToStringTrue(){
        System.out.println("CalendarToStringTest");
        Calendar date = Util.StringToCalendar("12/12/2012");
        assertEquals("12122012", Util.CalendarToString(date));
    }
}
