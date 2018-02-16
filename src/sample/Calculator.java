package sample;

import javafx.scene.control.TextField;

public class Calculator {

    private String strDisplayValue; //
    //private int numberOfDigits; //сколько разрядов отображается на дисплее
    private TextField display;  //ссылка на объект поля ввода
    private double dResultValue = 0;
    private String strLastAction = "";

    public void initialize(TextField display) {
        this.strDisplayValue = display.getText();
        //this.numberOfDigits = 7;
        this.display = display;
    }

    public void append(String append) {
        //если в поле ввода сейчас цифра "0" или все разряды дисплея уже заполнены
        if (strDisplayValue.equals("0")) {
            //то вместо 0 выводим цифру append
            strDisplayValue = append;
        }
        else {
            //иначе прибавляем к значению из поля ввода цифру append
            strDisplayValue += append;
        }
        //показать новое значение в поле ввода
        showValueOnDisplay();
    }

    public void backspace() {
        //удалить последнюю цифру
        String withoutTheLast = strDisplayValue.substring(0, strDisplayValue.length()-1);
        //если убираем последний символ
        if (withoutTheLast.equals("")) {
            //то вывести на дисплей 0
            withoutTheLast = "0";
        }

        strDisplayValue = withoutTheLast;
        //показать новое значение
        showValueOnDisplay();
    }

    public void clean() {
        strDisplayValue = "0";
        dResultValue = 0;
        strLastAction = "";
        showValueOnDisplay();
    }

    public void plus() {
        dResultValue += Double.valueOf(strDisplayValue);
        System.out.printf("strDisplayValue => %s; dResultValue => %f \n", strDisplayValue, dResultValue);
        strDisplayValue = "0";
        strLastAction = "+";
        showValueOnDisplay();
    }

    private double minus(double val){
        strLastAction = "-";
        return dResultValue -= val;
    }

    private double multiply(double val) {
        strLastAction = "*";
        return dResultValue *= val;
    }

    private double divide(double val) {
        strLastAction = "/";
        return dResultValue /= val;
    }

    public void equals() {
        switch (strLastAction) {
            case "+":
                dResultValue += Double.valueOf(strDisplayValue);
                break;
        }

        //вывести на дисплей значение dResultValue
        strDisplayValue = String.valueOf(dResultValue);
        showValueOnDisplay();

        //todo после equals() plus() прибавляет старое значение
    }

    public void dot() {
        //точка может быть только одна
        if (strDisplayValue.contains(".")) {
            return;
        }

        strDisplayValue += ".";
        showValueOnDisplay();
    }

    private void showValueOnDisplay() {
        display.setText(strDisplayValue);
    }
}
