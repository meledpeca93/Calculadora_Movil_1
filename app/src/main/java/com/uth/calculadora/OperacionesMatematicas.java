package com.uth.calculadora;

/** Encapsula los dos operandos recibidos mediante el constructor. */
public final class OperacionesMatematicas {
    private final double primero;
    private final double segundo;

    public OperacionesMatematicas(double primero, double segundo) {
        if (!Double.isFinite(primero) || !Double.isFinite(segundo)) {
            throw new IllegalArgumentException("Ingresa números finitos.");
        }
        this.primero = primero;
        this.segundo = segundo;
    }

    public double sumar() { return validarResultado(primero + segundo); }
    public double restar() { return validarResultado(primero - segundo); }
    public double multiplicar() { return validarResultado(primero * segundo); }
    public double dividir() {
        if (segundo == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return validarResultado(primero / segundo);
    }

    private double validarResultado(double resultado) {
        if (!Double.isFinite(resultado)) {
            throw new ArithmeticException("El resultado excede el rango permitido.");
        }
        return resultado;
    }
}
