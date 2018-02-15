package sample;

import javafx.scene.control.TextField;

public class Calculator {

    private String displayValue; //
    private int numberOfDigits; //сколько разрядов отображается на дисплее
    private TextField display;  //ссылка на объект поля ввода
    private double resultValue = 0;

    public void initialize(TextField display) {
        this.displayValue = display.getText();
        this.numberOfDigits = 7;
        this.display = display;
    }

    public void append(String append) {
        //если в поле ввода сейчас цифра "0" или все разряды дисплея уже заполнены
        if (displayValue.equals("0")) {
            //то вместо 0 выводим цифру append
            displayValue = append;
        }
        else {
            //иначе прибавляем к значению из поля ввода цифру append
            displayValue += append;
        }
        //показать новое значение в поле ввода
        showValueOnDisplay();
    }

    public void backspace() {
        //удалить последнюю цифру
        String withoutTheLast = displayValue.substring(0, displayValue.length()-1);
        //если убираем последний символ
        if (withoutTheLast.equals("")) {
            //то вывести на дисплей 0
            withoutTheLast = "0";
        }

        displayValue = withoutTheLast;
        //показать новое значение
        showValueOnDisplay();
    }

    public void clean() {
        displayValue = "0";
        resultValue = 0;
        showValueOnDisplay();
    }

    public void plus() {
        resultValue += Double.valueOf(displayValue);
        System.out.printf("displayValue => %s; resultValue => %f \n", displayValue, resultValue);
        displayValue = "0";
        showValueOnDisplay();
    }

    private double minus(double val){
        return resultValue -= val;
    }

    private double multiply(double val) {
        return resultValue *= val;
    }

    private double divide(double val) {
        return resultValue /= val;
    }

    public void equals() {
        //вывести на дисплей значение resultValue
        display.setText(String.valueOf(resultValue));
    }

    public void dot() {
        //точка может быть только одна
        if (displayValue.contains(".")) {
            return;
        }

        displayValue += ".";
        showValueOnDisplay();
    }

    private void showValueOnDisplay() {
        display.setText(displayValue);
    }
}
