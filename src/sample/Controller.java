package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField tfDisplay;
    private Calculator calc = new Calculator();

    /*Controller(){
        calc = new Calculator();
    }*/

    public void onActionKeyPress(ActionEvent actionEvent) {
        processAction((Button) actionEvent.getSource());
    }

    public void onDigitKeyPress(ActionEvent actionEvent) {
          processDigit((Button) actionEvent.getSource());
    }

    @FXML
    private void initialize() {
        calc.initialize(tfDisplay);
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

            case "btnDot":
                calc.dot();
                break;

            case "btnPlus":
                calc.operation("+");
                break;

            case "btnMinus":
                calc.operation("-");
                break;

            case "btnDivide":
                calc.operation("/");
                break;

            case "btnMultiply":
                calc.operation("*");
                break;

            case "btnEquals":
                calc.equals();
                break;
        }
    }

    public void keyPressed(String key){
        //если была нажата клавиша цифра
        if(key.matches("[0-9]")){ // \\d   –  цифровой символ
            calc.append(key);
        } //если была нажата клавиша операции - + * /
        else if (key.matches("[-+*/=]")){ //Диапазон символов или цифр
            calc.operation(key);
        }
    }
}
