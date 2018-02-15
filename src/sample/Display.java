package sample;

import javafx.scene.control.TextField;

public class Display {
    private String digits;
    private int numberOfDigits; //сколько разрядов отображается на дисплее
    private TextField display;  //ссылка на объект поля ввода

    public void initialize(TextField display) {
        this.digits = display.getText();
        this.numberOfDigits = 7;
        this.display = display;
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
        display.setText(digits);
    }

    public void backspace() {
        //удалить последнюю цифру
        String withoutTheLast = digits.substring(0, digits.length()-1);
        //если убираем последний символ
        if (withoutTheLast.equals("")) {
            //то вывести на дисплей 0
            withoutTheLast = "0";
        }

        digits = withoutTheLast;
        //показать новое значение
        display.setText(digits);
    }

    public void clean() {
        digits = "0";
        display.setText(digits);
    }
}
