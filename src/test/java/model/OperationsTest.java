package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    @DisplayName("Addition")
    void add() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        Polynomial b = new Polynomial("3x^3+7");
        assertEquals("-1.0x^4+3.0x^2-7.0", Operations.add(a, b).toString());
    }

    @Test
    @DisplayName("Subtraction")
    void subtract() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        Polynomial b = new Polynomial("3x^3+7");
        assertEquals("-1.0x^4-6.0x^3+3.0x^2-21.0", Operations.subtract(a, b).toString());
    }

    @Test
    @DisplayName("Multiplication")
    void multiply() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        Polynomial b = new Polynomial("3x^3+7");
        assertEquals("-3.0x^7-9.0x^6+9.0x^5-7.0x^4-63.0x^3+21.0x^2-98.0", Operations.multiply(a, b).toString());
    }

    @Test
    @DisplayName("Division")
    void divide() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        Polynomial b = new Polynomial("3x^3+7");
        assertEquals("-0.3333333333333333x-1.0", Operations.divide(a, b).toString());
        assertEquals("3.0x^2+2.333333333333333x-7.0", a.toString());
    }

    @Test
    @DisplayName("Derivation")
    void derive() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        assertEquals("-4.0x^3-9.0x^2+6.0x", Operations.derive(a).toString());
    }

    @Test
    @DisplayName("Integration")
    void integrate() {
        Polynomial a = new Polynomial("-x^4-3x^3+3x^2-14");
        assertEquals("-0.2x^5-0.75x^4+1.0x^3-14.0x", Operations.integrate(a).toString());
    }
}
