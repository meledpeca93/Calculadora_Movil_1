package com.uth.calculadora;

import java.math.BigDecimal;

/** Presenta números cotidianos en decimal y magnitudes extremas en notación científica. */
public final class FormatoNumero {
    private static final double LIMITE_GRANDE = 1e12;
    private static final double LIMITE_PEQUENO = 1e-9;

    private FormatoNumero() { }

    public static String formatear(double numero) {
        if (!Double.isFinite(numero)) {
            throw new IllegalArgumentException("El número debe ser finito.");
        }
        if (numero == 0) return "0";
        BigDecimal decimal = BigDecimal.valueOf(numero).stripTrailingZeros();
        double magnitud = Math.abs(numero);
        if (magnitud >= LIMITE_GRANDE || magnitud < LIMITE_PEQUENO) {
            int exponente = decimal.precision() - decimal.scale() - 1;
            String mantisa = decimal.movePointLeft(exponente).toPlainString();
            return mantisa + "E" + (exponente >= 0 ? "+" : "") + exponente;
        }
        return decimal.toPlainString();
    }
}
