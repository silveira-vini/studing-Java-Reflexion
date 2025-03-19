package ribeiro.silveira.vinicius.studingjavareflexion;

import org.junit.jupiter.api.Test;
import ribeiro.silveira.vinicius.studingjavareflexion.exception.InvalidCpfException;
import ribeiro.silveira.vinicius.studingjavareflexion.model.Cpf;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void testValidCpf() {
        assertDoesNotThrow(() -> new Cpf("12345678909"));
        assertDoesNotThrow(() -> new Cpf("111.444.777-35"));
        assertDoesNotThrow(() -> new Cpf("021.900.541-92"));
        assertDoesNotThrow(() -> new Cpf("012.345.678-90"));
        assertDoesNotThrow(() -> new Cpf("040.237.381/23"));
    }

    @Test
    void testInvalidCpfWithInvalidLength() {
        InvalidCpfException exception = assertThrows(InvalidCpfException.class, () -> new Cpf("123"));
        assertEquals("CPF inválido", exception.getMessage());

        exception = assertThrows(InvalidCpfException.class, () -> new Cpf("1234567890912"));
        assertEquals("CPF inválido", exception.getMessage());
    }

    @Test
    void testInvalidCpfWithAllDigitsEqual() {
        InvalidCpfException exception = assertThrows(InvalidCpfException.class, () -> new Cpf("11111111111"));
        assertEquals("CPF inválido", exception.getMessage());

        exception = assertThrows(InvalidCpfException.class, () -> new Cpf("00000000000"));
        assertEquals("CPF inválido", exception.getMessage());
    }

    @Test
    void testInvalidCpfWithInvalidFirstDigit() {
        InvalidCpfException exception = assertThrows(InvalidCpfException.class, () -> new Cpf("12345678910"));
        assertEquals("CPF inválido", exception.getMessage());
    }

    @Test
    void testInvalidCpfWithInvalidSecondDigit() {
        InvalidCpfException exception = assertThrows(InvalidCpfException.class, () -> new Cpf("12345678900"));
        assertEquals("CPF inválido", exception.getMessage());
    }

    @Test
    void testValidateValidCpf() {
        assertTrue(Cpf.validate("12345678909"));
        assertTrue(Cpf.validate("111.444.777-35"));
        assertTrue(Cpf.validate("021.900.541-92"));
        assertTrue(Cpf.validate("012.345.678-90"));
        assertTrue(Cpf.validate("040.237.381/23"));
    }

    @Test
    void testValidateInvalidCpfWithInvalidLength() {
        assertFalse(Cpf.validate("123"));
        assertFalse(Cpf.validate("1234567890912"));
    }

    @Test
    void testValidateInvalidCpfWithAllDigitsEqual() {
        assertFalse(Cpf.validate("11111111111"));
        assertFalse(Cpf.validate("00000000000"));
    }

    @Test
    void testValidateInvalidCpfWithInvalidFirstDigit() {
        assertFalse(Cpf.validate("12345678910"));
    }

    @Test
    void testValidateInvalidCpfWithInvalidSecondDigit() {
        assertFalse(Cpf.validate("12345678900"));
    }

    @Test
    void testCpfRecordImmutability() {
        Cpf cpf = new Cpf("12345678909");
        assertEquals("12345678909", cpf.cpf());
    }
}