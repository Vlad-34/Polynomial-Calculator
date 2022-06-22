package model;

public class Monomial implements Comparable<Monomial> {
    private double coefficient;
    private int exponent;

    public Monomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    @Override
    public int compareTo(Monomial that) {
        return that.getExponent() - this.getExponent();
    }

    @Override
    public String toString() {
        return coefficient + "x^" + exponent;
    }
}
