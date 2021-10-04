package utils;

import main.utils.DataValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"84163129073", "79628236075", "68242394024", "55195209090", "38976555007", "08100434085"})
    public void isCPFTest(String str){
        assertTrue(DataValidator.isCpf(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999", "00000000000"})
    public void isCPFInvalidTest(String str){
        assertFalse(DataValidator.isCpf(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"841639073", "7962826075", "682394024", "195209090", "3897650078596666", "0434085"})
    public void isCPFInvalidFormattingTest(String str){
        assertFalse(DataValidator.isCpf(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"841a6312903", "796vv282375", "6824gg23940", "55199hy52090", "389765007ol", "08143408po5"})
    public void isCPFWithLetterTest(String str){
        assertFalse(DataValidator.isCpf(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"841", "8236", "694024", "5", "07", "085"})
    public void isNumberTest(String str){
        assertTrue(DataValidator.isNumber(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11.1", "2296.2", "33.33", "44,58", "5,85", "66,62", "77785´855", "8*66"})
    public void isNumberInvalidTest(String str){
        assertFalse(DataValidator.isNumber(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", "  68024", "1952   09090", "  ", " 0.0 "})
    public void isNumberInvalidFormattingTest(String str){
        assertFalse(DataValidator.isNumber(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"41a6", "796v", "6g23", "59hy0", "7ol", "8po5"})
    public void isNumberWithLetterTest(String str){
        assertFalse(DataValidator.isNumber(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"15/08/2003", "17/01/2000", "19/05/1965", "31/12/2010", "15/08/2017", "19/10/2026"})
    public void isDateTest(String str){
        Date date = DataValidator.formatStringInDate(str);
        assertEquals(str, DataValidator.formatDateInString(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11.1", "2296.2", "33.33", "44,58", "5,85", "66,62", "77785´855", "8*66"})
    public void isDateInvalidTest(String str){
        Date date = DataValidator.formatStringInDate(str);
        assertNull(DataValidator.formatDateInString(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"   ", "  68024", "1952   09090", "  ", " 0.0 "})
    public void isDateInvalidFormattingTest(String str){
        Date date = DataValidator.formatStringInDate(str);
        assertNull(DataValidator.formatDateInString(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"41a6", "796v", "6g23", "59hy0", "7ol", "8po5"})
    public void isDateWithLetterTest(String str){
        Date date = DataValidator.formatStringInDate(str);
        assertNull(DataValidator.formatDateInString(date));
    }

    @Test
    public void isStringToDateTest(){
        Date date = new GregorianCalendar(2000, GregorianCalendar.JULY, 17).getTime();
        assertEquals(date, DataValidator.formatStringInDate("17/07/2000"));
    }

}
