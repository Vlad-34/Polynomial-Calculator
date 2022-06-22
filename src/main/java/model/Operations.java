package model;

import java.util.Collections;

public abstract class Operations {
    public static Polynomial invert(Polynomial a) {
        for (int i = 0; i < a.getPolynomialMembers().size(); i++) {
            a.getPolynomialMembers().get(i).setCoefficient(-a.getPolynomialMembers().get(i).getCoefficient());
        }
        return a;
    }

    public static Polynomial add(Polynomial a, Polynomial b) {
        Collections.sort(a.getPolynomialMembers());
        Collections.sort(b.getPolynomialMembers());
        Polynomial c = new Polynomial("");
        int m = a.getPolynomialMembers().size(), n = b.getPolynomialMembers().size();
        int i = 0, j = 0;

        while (i < m || j < n) {
            Monomial monomial = new Monomial(0, 0);
            if (i == m) {
                c.getPolynomialMembers().add(b.getPolynomialMembers().get(j));
                j++;
            } else if (j == n) {
                c.getPolynomialMembers().add(a.getPolynomialMembers().get(i));
                i++;
            } else if (a.getPolynomialMembers().get(i).getExponent() == b.getPolynomialMembers().get(j).getExponent()) {
                if (!(a.getPolynomialMembers().get(i).getCoefficient() + b.getPolynomialMembers().get(j).getCoefficient() < 1 && a.getPolynomialMembers().get(i).getCoefficient() + b.getPolynomialMembers().get(j).getCoefficient() > -1)) {
                    monomial.setCoefficient(a.getPolynomialMembers().get(i).getCoefficient() + b.getPolynomialMembers().get(j).getCoefficient());
                    monomial.setExponent(a.getPolynomialMembers().get(i).getExponent());
                    c.getPolynomialMembers().add(monomial);
                }
                i++;
                j++;
            } else if (a.getPolynomialMembers().get(i).getExponent() > b.getPolynomialMembers().get(j).getExponent()) {
                c.getPolynomialMembers().add(a.getPolynomialMembers().get(i));
                i++;
            } else {
                c.getPolynomialMembers().add(b.getPolynomialMembers().get(j));
                j++;
            }
        }
        Collections.sort(c.getPolynomialMembers());
        return c;
    }

    public static Polynomial subtract(Polynomial a, Polynomial b) {
        Collections.sort(a.getPolynomialMembers());
        Collections.sort(b.getPolynomialMembers());
        return Operations.add(a, invert(b));
    }

    public static Polynomial multiply(Polynomial a, Polynomial b) {
        Collections.sort(a.getPolynomialMembers());
        Collections.sort(b.getPolynomialMembers());
        Polynomial c = new Polynomial("");

        int m = a.getPolynomialMembers().size(), n = b.getPolynomialMembers().size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Monomial monomial = new Monomial(a.getPolynomialMembers().get(i).getCoefficient() * b.getPolynomialMembers().get(j).getCoefficient(), a.getPolynomialMembers().get(i).getExponent() + b.getPolynomialMembers().get(j).getExponent());
                c.getPolynomialMembers().add(monomial);
            }
        }
        for (int i = 0; i < c.getPolynomialMembers().size() - 1; i++) {
            for (int j = i + 1; j < c.getPolynomialMembers().size(); j++) {
                if (c.getPolynomialMembers().get(i).getExponent() == c.getPolynomialMembers().get(j).getExponent()) {
                    c.getPolynomialMembers().get(i).setCoefficient(c.getPolynomialMembers().get(i).getCoefficient() + c.getPolynomialMembers().get(j).getCoefficient());
                    c.getPolynomialMembers().remove(j);
                }
            }
        }
        Collections.sort(c.getPolynomialMembers());
        return c;
    }

    public static Polynomial divide(Polynomial a, Polynomial b) {
        Collections.sort(a.getPolynomialMembers());
        Collections.sort(b.getPolynomialMembers());
        Polynomial c = new Polynomial("");
        if (!b.toString().equals("0.0") && !b.toString().equals("")) {
            Polynomial r = new Polynomial("");
            Polynomial scalar = new Polynomial("");

            while (a.getPolynomialMembers() != null) {
                if (a.getPolynomialMembers().get(0).getExponent() < b.getPolynomialMembers().get(0).getExponent())
                    break;
                Monomial monomial = new Monomial(0, 0);
                double monomialCoefficient = a.getPolynomialMembers().get(0).getCoefficient() / b.getPolynomialMembers().get(0).getCoefficient();
                monomial.setCoefficient(monomialCoefficient);
                monomial.setExponent(a.getPolynomialMembers().get(0).getExponent() - b.getPolynomialMembers().get(0).getExponent());
                c.getPolynomialMembers().add(monomial);

                scalar.getPolynomialMembers().add(monomial);
                r.setPolynomialMembers(Operations.subtract(a, Operations.multiply(b, scalar)).getPolynomialMembers());
                if (r.getPolynomialMembers().size() == 0) {
                    a.setPolynomialMembers(null);
                } else {
                    a.setPolynomialMembers(r.getPolynomialMembers());
                }
                scalar.getPolynomialMembers().clear();
            }
        } else {
            a.getPolynomialMembers().clear();
        }

        return c;
    }

    public static Polynomial derive(Polynomial a) {
        Collections.sort(a.getPolynomialMembers());
        for (int i = 0; i < a.getPolynomialMembers().size(); i++) {
            double coefficient = a.getPolynomialMembers().get(i).getCoefficient();
            int exponent = a.getPolynomialMembers().get(i).getExponent();
            a.getPolynomialMembers().get(i).setCoefficient(coefficient * exponent);
            a.getPolynomialMembers().get(i).setExponent(exponent - 1);
        }
        return a;
    }

    public static Polynomial integrate(Polynomial a) {
        Collections.sort(a.getPolynomialMembers());
        for (int i = 0; i < a.getPolynomialMembers().size(); i++) {
            double coefficient = a.getPolynomialMembers().get(i).getCoefficient();
            int exponent = a.getPolynomialMembers().get(i).getExponent();
            a.getPolynomialMembers().get(i).setCoefficient(coefficient / (exponent + 1));
            a.getPolynomialMembers().get(i).setExponent(exponent + 1);
        }
        return a;
    }
}
