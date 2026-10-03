package com.uth.calculadora;

import org.junit.Test;
import static org.junit.Assert.*;

public class OperacionesMatematicasTest {
    @Test public void operacionesConNegativosYDecimales() {
        OperacionesMatematicas op = new OperacionesMatematicas(-7.5, 2.5);
        assertEquals(-5, op.sumar(), 0);
        assertEquals(-10, op.restar(), 0);
        assertEquals(-18.75, op.multiplicar(), 0);
        assertEquals(-3, op.dividir(), 0);
    }
    @Test public void ceroPuedeSerNumerador() {
        assertEquals(0, new OperacionesMatematicas(0, 5).dividir(), 0);
    }
    @Test public void rechazaAmbosSignosDeCeroComoDivisor() {
        for (double cero : new double[]{0.0, -0.0}) {
            assertThrows(ArithmeticException.class,
                    () -> new OperacionesMatematicas(7, cero).dividir());
        }
    }
    @Test public void rechazaDesbordamientoYOperandosNoFinitos() {
        assertThrows(ArithmeticException.class,
                () -> new OperacionesMatematicas(Double.MAX_VALUE, 2).multiplicar());
        assertThrows(IllegalArgumentException.class,
                () -> new OperacionesMatematicas(Double.NaN, 1));
        assertThrows(IllegalArgumentException.class,
                () -> new OperacionesMatematicas(1, Double.POSITIVE_INFINITY));
    }
    @Test public void aceptaSeparadoresDecimalesYEspacios() {
        assertEquals(-2.5, EntradaNumerica.convertir(" -2,5 "), 0);
        assertEquals(0.5, EntradaNumerica.convertir(".5"), 0);
        assertEquals(12, EntradaNumerica.convertir("+12"), 0);
    }
    @Test public void rechazaEntradasInvalidas() {
        for (String valor : new String[]{"", "  ", "hola", "NaN", "Infinity", "1,2.3", "--2", "1 000", "1e3"}) {
            assertThrows(IllegalArgumentException.class, () -> EntradaNumerica.convertir(valor));
        }
        assertThrows(IllegalArgumentException.class,
                () -> EntradaNumerica.convertir(new String(new char[310]).replace('\0', '9')));
    }
}
