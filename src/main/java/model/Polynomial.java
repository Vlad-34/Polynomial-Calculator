package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> polynomialMembers;

    public Polynomial(String expression) {
        this.polynomialMembers = new ArrayList<>();

        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        expression = expression.replace(" ", ""); // kill whitespace
        expression = expression.replace("*", ""); // kill *
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String monomial = matcher.group(1);
            String[] group = monomial.split("[xX]", 3); // split individual monomials

            double coefficient = 0;
            int exponent = 0;
            try {
                if (group.length == 2) {
                    String replace = group[1].replace("^", "");
                    if (group[0].equals("") || group[0].equals("+")) {
                        coefficient = 1;
                    } else if (group[0].equals("-")) {
                        coefficient = -1;
                    } else {
                        coefficient = Double.parseDouble(group[0]);
                    }

                    if (group[1].equals("") || group[1].equals("+")) {
                        exponent = 1;
                    } else {
                        exponent = Integer.parseInt(replace);
                    }
                }
                if (group.length == 1) {
                    coefficient = Double.parseDouble(group[0]);
                }
            } catch (NumberFormatException e) {
                this.getPolynomialMembers().clear();
            }
            this.polynomialMembers.add(new Monomial(coefficient, exponent));
        }
    }

    public ArrayList<Monomial> getPolynomialMembers() {
        return polynomialMembers;
    }

    public void setPolynomialMembers(ArrayList<Monomial> polynomialMembers) {
        this.polynomialMembers = polynomialMembers;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.getPolynomialMembers().size(); i++) {
            if (i != 0 && this.polynomialMembers.get(i).getCoefficient() > 0)
                result += "+";
            if (this.polynomialMembers.get(i).getCoefficient() != 0) {
                if (this.polynomialMembers.get(i).getExponent() == 0) {
                    result += this.polynomialMembers.get(i).getCoefficient();
                } else if (this.polynomialMembers.get(i).getExponent() == 1) {
                    result += this.polynomialMembers.get(i).getCoefficient() + "x";
                } else if (this.polynomialMembers.get(i).getExponent() >= 2) {
                    result += this.polynomialMembers.get(i).getCoefficient() + "x^" + this.polynomialMembers.get(i).getExponent();
                } else if (i == 0) {
                    result += "0";
                }
            }
        }
        return result;
    }
}
