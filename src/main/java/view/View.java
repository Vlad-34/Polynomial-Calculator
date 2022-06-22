package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class View extends JFrame {

    private JTextField polynomial1TextField;
    private JTextField polynomial2TextField;
    private JTextField resultTextField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton deriveButton;
    private JButton integrateButton;

    public View() {
        this.setBounds(100, 100, 640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("CALCULATOR POLINOMIAL");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(188, 35, 250, 17);
        this.getContentPane().add(titleLabel);

        JLabel polynomial1Label = new JLabel("Polinom 1");
        polynomial1Label.setHorizontalAlignment(SwingConstants.CENTER);
        polynomial1Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        polynomial1Label.setBounds(269, 76, 88, 25);
        this.getContentPane().add(polynomial1Label);

        polynomial1TextField = new JTextField();
        polynomial1TextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        polynomial1TextField.setBounds(96, 110, 434, 25);
        this.getContentPane().add(polynomial1TextField);

        JLabel polynomial2Label = new JLabel("Polinom 2");
        polynomial2Label.setHorizontalAlignment(SwingConstants.CENTER);
        polynomial2Label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        polynomial2Label.setBounds(269, 145, 88, 25);
        this.getContentPane().add(polynomial2Label);

        polynomial2TextField = new JTextField();
        polynomial2TextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        polynomial2TextField.setColumns(10);
        polynomial2TextField.setBounds(96, 179, 434, 25);
        this.getContentPane().add(polynomial2TextField);

        addButton = new JButton("Adunare");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        addButton.setBounds(96, 230, 215, 25);
        this.getContentPane().add(addButton);

        subtractButton = new JButton("Scadere");
        subtractButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        subtractButton.setBounds(315, 230, 215, 25);
        this.getContentPane().add(subtractButton);

        multiplyButton = new JButton("Inmultire");
        multiplyButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        multiplyButton.setBounds(96, 265, 215, 25);
        this.getContentPane().add(multiplyButton);

        divideButton = new JButton("Impartire");
        divideButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        divideButton.setBounds(315, 265, 215, 25);
        this.getContentPane().add(divideButton);

        deriveButton = new JButton("Derivare");
        deriveButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deriveButton.setBounds(96, 300, 215, 25);
        this.getContentPane().add(deriveButton);

        integrateButton = new JButton("Integrare");
        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        integrateButton.setBounds(315, 300, 215, 25);
        this.getContentPane().add(integrateButton);

        JLabel resultLabel = new JLabel("Rezultat");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultLabel.setBounds(269, 341, 88, 25);
        this.getContentPane().add(resultLabel);

        resultTextField = new JTextField();
        resultTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        resultTextField.setColumns(10);
        resultTextField.setBounds(96, 375, 434, 25);
        this.getContentPane().add(resultTextField);
    }

    public String getPolynomial1TextField() {
        return polynomial1TextField.getText();
    }

    public String getPolynomial2TextField() {
        return polynomial2TextField.getText();
    }

    public void setResultTextField(String string) {
        this.resultTextField.setText(string);
    }

    public void addAddListener(ActionListener action) {
        addButton.addActionListener(action);
    }

    public void addSubtractListener(ActionListener action) {
        subtractButton.addActionListener(action);
    }

    public void addMultiplyListener(ActionListener action) {
        multiplyButton.addActionListener(action);
    }

    public void addDivideListener(ActionListener action) {
        divideButton.addActionListener(action);
    }

    public void addDeriveListener(ActionListener action) {
        deriveButton.addActionListener(action);
    }

    public void addIntegrateListener(ActionListener action) {
        integrateButton.addActionListener(action);
    }
}
