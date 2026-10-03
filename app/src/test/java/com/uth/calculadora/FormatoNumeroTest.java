package com.uth.calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

public class FormatoNumeroTest {
    @Test public void numerosHabitualesNoUsanExponente() {
        assertEquals("20", FormatoNumero.formatear(20));
        assertEquals("1000", FormatoNumero.formatear(1000));
        assertEquals("12300000", FormatoNumero.formatear(12300000));
        assertEquals("-2500", FormatoNumero.formatear(-2500));
        assertEquals("12.5", FormatoNumero.formatear(12.5));
        assertEquals("0.00000001", FormatoNumero.formatear(1e-8));
    }
    @Test public void respetaLosLimitesSinRedondear() {
        assertEquals("999999999999", FormatoNumero.formatear(999999999999d));
        assertEquals("1E+12", FormatoNumero.formatear(1e12));
        assertEquals("0.000000001", FormatoNumero.formatear(1e-9));
        assertEquals("-0.000000001", FormatoNumero.formatear(-1e-9));
        assertTrue(FormatoNumero.formatear(Math.nextDown(1e-9)).contains("E"));
    }
    @Test public void magnitudesExtremasUsanNotacionCientifica() {
        assertEquals("1.25E+15", FormatoNumero.formatear(1.25e15));
        assertEquals("-1.25E+15", FormatoNumero.formatear(-1.25e15));
        assertEquals("3.5E-10", FormatoNumero.formatear(3.5e-10));
        assertEquals("-3.5E-10", FormatoNumero.formatear(-3.5e-10));
        assertTrue(FormatoNumero.formatear(Double.MAX_VALUE).contains("E+308"));
        assertTrue(FormatoNumero.formatear(Double.MIN_VALUE).contains("E-324"));
    }
    @Test public void ceroNoUsaExponenteNiSignoNegativo() {
        assertEquals("0", FormatoNumero.formatear(0));
        assertEquals("0", FormatoNumero.formatear(-0.0));
    }
}
