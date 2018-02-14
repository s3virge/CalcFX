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
        processKeyPress((Button) actionEvent.getSource());
    }

    public void onDigitKeyPress(ActionEvent actionEvent) {
    }

    private void processKeyPress(Button clickedBtn) {
        switch (clickedBtn.getId()) {
            case "btnClean":
                tfDispley.setText(String.format("%f", calc.clean()));
                break;

            case "btnBackspace":
                calc.backspace();
                break;
        }
    }
}
