import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JPanel calculatorPanel;
    private JTextField outputField;
    private JButton numberOne;
    private JButton numberFive;
    private JButton numberSix;
    private JButton subtract;
    private JButton numberFour;
    private JButton numberTwo;
    private JButton numberThree;
    private JButton add;
    private JButton numberSeven;
    private JButton numberEight;
    private JButton numberNine;
    private JButton multiply;
    private JButton dot;
    private JButton numberZero;
    private JButton equals;
    private JButton divide;
    private JButton clear;
    private JButton undo;
    private JButton squareRoot;
    private JButton powerOf;
    private Double numberBuffer = 0.0;
    private Double result = 0.0;
    private String operation = "";

    public Calculator() {

        // defining number buttons actions
        numberOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "1";
                outputField.setText(newOutput);
            }
        });

        numberTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "2";
                outputField.setText(newOutput);
            }
        });

        numberThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "3";
                outputField.setText(newOutput);
            }
        });

        numberFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "4";
                outputField.setText(newOutput);
            }
        });

        numberFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "5";
                outputField.setText(newOutput);
            }
        });

        numberSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "6";
                outputField.setText(newOutput);
            }
        });

        numberSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "7";
                outputField.setText(newOutput);
            }
        });

        numberEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "8";
                outputField.setText(newOutput);
            }
        });

        numberNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "9";
                outputField.setText(newOutput);
            }
        });

        numberZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newOutput = outputField.getText() + "0";
                outputField.setText(newOutput);
            }
        });

        dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (outputField.getText().isEmpty()) {
                    return;
                }
                if (outputField.getText().contains(".")) {
                    return;
                }
                String newOutput = outputField.getText() + ".";
                outputField.setText(newOutput);
            }
        });


        // defining operation buttons actions
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("add");
            }
        });

        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("subtract");
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("multiply");
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("divide");
            }
        });

        powerOf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperation("powerOf");
            }
        });

        squareRoot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberBuffer = Double.parseDouble(outputField.getText());
                result = Math.sqrt(numberBuffer);
                String output = removeZerosIfNecessary(result.toString());
                outputField.setText(output);
            }
        });

        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(operation) {
                    case "add":
                        result = numberBuffer + Double.parseDouble(outputField.getText());
                        break;
                    case "subtract":
                        result = numberBuffer - Double.parseDouble(outputField.getText());
                        break;
                    case "multiply":
                        result = numberBuffer * Double.parseDouble(outputField.getText());
                        break;
                    case "divide":
                        result = numberBuffer / Double.parseDouble(outputField.getText());
                        break;
                    case "powerOf":
                        result = Math.pow(numberBuffer, Double.parseDouble(outputField.getText()));
                        break;
                    default:
                        result = Double.parseDouble(outputField.getText());
                        break;
                }
                String output = removeZerosIfNecessary(result.toString());
                outputField.setText(output);
                operation = "";
            }
        });

        // defining utility buttons actions
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (outputField.getText().isEmpty() == false) {
                    String newOutput = outputField.getText().substring(0, outputField.getText().length()-1);
                    outputField.setText(newOutput);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputField.setText("");
            }
        });
    }

    public void setOperation(String requestedOperation) {
        if (outputField.getText().isEmpty()) {
            return;
        }
        numberBuffer = Double.parseDouble(outputField.getText());
        operation = requestedOperation;
        outputField.setText("");
    }

    // remove zeros if their presence is redundant in the output field
    public String removeZerosIfNecessary(String output) {
        String[] splitOutput = output.split("\\.");
        String outputNumbersBeforeComma = splitOutput[0];
        String outputNumbersAfterComma = splitOutput[1];
        for (Character c : outputNumbersAfterComma.toCharArray()) {
            if (c != '0') {
                return output;
            }
        }
        return outputNumbersBeforeComma;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        Calculator calculator = new Calculator();
        frame.setContentPane(calculator.calculatorPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}