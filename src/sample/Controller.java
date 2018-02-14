package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField tfDispley;
    private Calculator calc = new Calculator();
    private Displey displey = new Displey();

    public void onActionKeyPress(ActionEvent actionEvent) {
        processAction((Button) actionEvent.getSource());
    }

    public void onDigitKeyPress(ActionEvent actionEvent) {
          processDigit((Button) actionEvent.getSource());
    }

    @FXML
    private void initialize() {
        displey.initialize(tfDispley);
    }


    private void processDigit(Button source) {
        switch(source.getId()) {
            case "btn0":
                displey.append("0");
                break;

            case "btn1":
                displey.append("1");
                break;

            case "btn2":
                displey.append("2");
                break;

            case "btn3":
                displey.append("3");
                break;

            case "btn4":
                displey.append("4");
                break;

            case "btn5":
                displey.append("5");
                break;

            case "btn6":
                displey.append("6");
                break;

            case "btn7":
                displey.append("7");
                break;

            case "btn8":
                displey.append("8");
                break;

            case "btn9":
                displey.append("9");
                break;
        }
    }

    private void processAction(Button clickedBtn) {
        switch (clickedBtn.getId()) {
            case "btnClean":
                displey.clean();
                break;

            case "btnBackspace":
                displey.backspace();
                break;
        }
    }
}
