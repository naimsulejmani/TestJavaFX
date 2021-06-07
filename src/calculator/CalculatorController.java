package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    //lidhja e variblave te clases Controller me fajllin e .fxml
    //behet nepermjet fx:id e cila duhet te jete edhe emer i objektit ne klase
    //gjithashtu duhet te jene te tipit te njejte
    @FXML //objekti i TextField
    private TextField txtResult;

    @FXML
    private Button btnPowXY;

    @FXML
    private Button btnCos;


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
            System.out.println("Cos Pressed");
        });

    }

    public void square() {

        System.out.println("Square button pressed");
        System.out.println(txtResult.getText());
    }


    public void sinPressed(ActionEvent event) {
        System.out.println("Sin Pressed");
    }

    public void setValue(ActionEvent event) {
        //if(event.getSource() instanceof Button)
        Button btn = (Button) event.getSource();

        //if(txtResult.getText().contains(".") && btn.getText().equals(".")) return;

        if (txtResult.getText().equals("0")) {
            txtResult.setText(btn.getText());
        } else {
            txtResult.setText(txtResult.getText() + btn.getText());
        }

    }

    public void setDotValue(ActionEvent actionEvent) {
        if (txtResult.getText().contains(".")) return;
        txtResult.setText(txtResult.getText() + ".");
    }
}
