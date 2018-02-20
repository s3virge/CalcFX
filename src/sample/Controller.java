package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField tfDispley;
    private Calculator calc = new Calculator();

    public void onActionKeyPress(ActionEvent actionEvent) {
        processAction((Button) actionEvent.getSource());
    }

    public void onDigitKeyPress(ActionEvent actionEvent) {
          processDigit((Button) actionEvent.getSource());
    }

    @FXML
    private void initialize() {
        calc.initialize(tfDispley);
    }

    private void processDigit(Button source) {
        switch(source.getId()) {
            case "btn0":
                calc.append("0");
                break;

            case "btn1":
                calc.append("1");
                break;

            case "btn2":
                calc.append("2");
                break;

            case "btn3":
                calc.append("3");
                break;

            case "btn4":
                calc.append("4");
                break;

            case "btn5":
                calc.append("5");
                break;

            case "btn6":
                calc.append("6");
                break;

            case "btn7":
                calc.append("7");
                break;

            case "btn8":
                calc.append("8");
                break;

            case "btn9":
                calc.append("9");
                break;
        }
    }

    private void processAction(Button clickedBtn) {
        switch (clickedBtn.getId()) {
            case "btnClean":
                calc.clean();
                break;

            case "btnBackspace":
                calc.backspace();
                break;

            case "btnPlus":
                calc.plus();
                break;

            case "btnMinus":
                calc.minus();
                break;

            case "btnDot":
                calc.dot();
                break;

            case "btnEquals":
                calc.equals();
                break;
        }
    }
}
