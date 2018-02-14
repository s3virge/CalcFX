package sample;

import javafx.scene.control.TextField;

public class Displey {
    private String digits;
    private int numberOfDigits; //сколько разрядов отображается на дисплее
    private TextField displey;  //ссылка на объект поля ввода

    public void initialize(TextField displey) {
        this.digits = displey.getText();
        this.numberOfDigits = 7;
        this.displey = displey;
    }

    public void append(String append) {
        //если в поле ввода сейчас цифра "0" или все разряды дисплея уже заполнены
        if (digits.equals("0")) {
            //то вместо 0 выводим цифру append
            digits = append;
        }
        else {
            //иначе прибавляем к значению из поля ввода цифру append
            digits += append;
        }
        //устанавливаем новое значение в поле ввода
        displey.setText(digits);
    }

    public void backspace() {
        //удалить последнюю цифру
        //показать новое значение
    }

    public void clean() {
        digits = "0";
        displey.setText(digits);
    }
}
