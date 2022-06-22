package controller;

import model.Operations;
import model.Polynomial;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;

        view.addAddListener(new AddListener());
        view.addSubtractListener(new SubtractListener());
        view.addMultiplyListener(new MultiplyListener());
        view.addDivideListener(new DivideListener());
        view.addDeriveListener(new DeriveListener());
        view.addIntegrateListener(new IntegrateListener());
    }

    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            Polynomial b = new Polynomial(view.getPolynomial2TextField());
            Collections.sort(a.getPolynomialMembers());
            Collections.sort(b.getPolynomialMembers());
            view.setResultTextField(String.valueOf(Operations.add(a, b)));
        }
    }

    public class SubtractListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            Polynomial b = new Polynomial(view.getPolynomial2TextField());
            Collections.sort(a.getPolynomialMembers());
            Collections.sort(b.getPolynomialMembers());
            view.setResultTextField(String.valueOf(Operations.subtract(a, b)));
        }
    }

    public class MultiplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            Polynomial b = new Polynomial(view.getPolynomial2TextField());
            Collections.sort(a.getPolynomialMembers());
            Collections.sort(b.getPolynomialMembers());
            view.setResultTextField(String.valueOf(Operations.multiply(a, b)));
        }
    }

    public class DivideListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            Polynomial b = new Polynomial(view.getPolynomial2TextField());
            Collections.sort(a.getPolynomialMembers());
            Collections.sort(b.getPolynomialMembers());

            String string = String.valueOf(Operations.divide(a, b));
            if (a.getPolynomialMembers() != null)
                string += " | " + a;
            view.setResultTextField(string);
        }
    }

    public class DeriveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            view.setResultTextField(String.valueOf(Operations.derive(a)));
        }
    }

    public class IntegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Polynomial a = new Polynomial(view.getPolynomial1TextField());
            view.setResultTextField(String.valueOf(Operations.integrate(a)));
        }
    }
}
