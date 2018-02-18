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

        System.out.printf("plus(); strDisplayValue => %s; dResultValue => %f \n", strDisplayValue, dResultValue);

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
        if (strLastAction.equals("="))
            return;

        switch (strLastAction) {
            case "+":
                dResultValue += Double.valueOf(strDisplayValue);
                break;
        }

        System.out.printf("equals(); strDisplayValue => %s; dResultValue => %f \n", strDisplayValue, dResultValue);

        //вывести на дисплей значение dResultValue
        strDisplayValue = String.valueOf(dResultValue);
        showValueOnDisplay();
        strLastAction = "=";
        dResultValue = 0;
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
        if (getNumberOfDigitsAfterDot() != 0) {
            //то на экране нужно показывать значения как целочисленные (без ".0")
            //todo показать на экране число без точки и нуля
            return;
        }
        display.setText(strDisplayValue);
    }

    private int getNumberOfDigitsAfterDot() {
        int numberOfDigits = 0;
        if (strDisplayValue.contains(".")) {
            int index = strDisplayValue.indexOf('.');
            String afterDot = strDisplayValue.substring(index + 1);
            numberOfDigits = afterDot.length();

            //если после запятой одна цифра и эта цифра ноль
            if (numberOfDigits == 1 && afterDot.equals("0")) {
                numberOfDigits = 0;
            }
        }
        return numberOfDigits;
    }
}
