package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    private double result = 0;
    private boolean isNewNumber = false;
    private String lastOperatorString = "";
    //lidhja e variblave te clases Controller me fajllin e .fxml
    //behet nepermjet fx:id e cila duhet te jete edhe emer i objektit ne klase
    //gjithashtu duhet te jene te tipit te njejte
    @FXML //objekti i TextField
    private TextField txtResult;

    @FXML
    private Button btnPowXY;

    @FXML
    private Button btnCos;

    @FXML
    private Button btnPI;

    @FXML
    private Button btnPlus;
    @FXML
    private Button btnMinus;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnMultiply;


    EventHandler<ActionEvent> operatorActionEvent = (ae) -> {
        Button btn = (Button) ae.getSource();
        String operator = btn.getText(); //+,-,/,x

        if(isNewNumber) {
            lastOperatorString = operator;
            return;
        }

        isNewNumber = true;
        Double number = Double.parseDouble(txtResult.getText());
        result = calculate(lastOperatorString, number);
        lastOperatorString = operator;
        txtResult.setText("" + result);
        //ktu eshte dashur te kalkulohet me last operaotr
    };


    EventHandler<ActionEvent> piActionEvent = (ae) -> {
        txtResult.setText("" + Math.PI);
    };

    //varargs ->
    private void setActionForButtons(EventHandler<ActionEvent> action, Button... buttons) {
        for (Button btn : buttons) {
            btn.setOnAction(action);
        }
    }


    private double calculate(String operator, double number) {
        double rez = result;
        switch (operator) {
            case "+":
                rez += number;
                break;
            case "-":
                rez -= number;
                break;
            case "x":
                rez *= number;
                break;
            case "/":
                rez /= number;
                break;
            default:
                rez = number;
                break;
        }
        return rez;
    }

    //ka nje metode inicializuese e cila vepron konstruktor
    public void initialize() {
        System.out.println("Initialize before everything else!");
        //btnPowXY vendosi nje ngjarje
        btnPowXY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Power X ^ Y");
            }
        });
        btnCos.setOnAction((ae) -> {
            Double number = Double.parseDouble(txtResult.getText());
            number = Math.cos(number);
            txtResult.setText("" + number);
            System.out.println("Cos Pressed");
        });
        btnPI.setOnAction(piActionEvent);

        setActionForButtons(operatorActionEvent, btnPlus, btnMinus, btnMultiply, btnDivide);
    }

    public void square() {
        Double number = Double.parseDouble(txtResult.getText());
        number *= number;//number = Math.pow(number,2);
        txtResult.setText(Double.toString(number));
        System.out.println("Square button pressed");
        System.out.println(txtResult.getText());
    }


    public void sinPressed(ActionEvent event) {
        Double number = Double.parseDouble(txtResult.getText());
        number = Math.sin(number);
        txtResult.setText("" + number);
        System.out.println("Sin Pressed");
    }

    public void setValue(ActionEvent event) {

        if (isNewNumber) {
            txtResult.setText("0");
            isNewNumber = false;
        }

        //if(event.getSource() instanceof Button)
        Button btn = (Button) event.getSource();
        if (txtResult.getText().equals("0")) {
            txtResult.setText(btn.getText());
        } else {
            txtResult.setText(txtResult.getText() + btn.getText());
        }
    }

    public void setDotValue(ActionEvent actionEvent) {
        if (isNewNumber) {
            txtResult.setText("0");
            isNewNumber = false;
        }

        if (txtResult.getText().contains(".")) return;
        txtResult.setText(txtResult.getText() + ".");
        //String m = "2";
        //m = m + "."
    }

    public void changeSign(ActionEvent actionEvent) {
        Double number = Double.parseDouble(txtResult.getText());
        number *= (-1);
        txtResult.setText("" + number);
    }

    public void clear(ActionEvent actionEvent) {
        txtResult.setText("0"); //resetForm();
    }
}
