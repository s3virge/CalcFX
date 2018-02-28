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
        if (strDisplayValue.equals("0") ) {
            //то вместо 0 выводим цифру append
            strDisplayValue = append;
        }
        else {
            //иначе прибавляем к значению из поля ввода цифру append
            strDisplayValue += append;
        }
        //показать новое значение в поле ввода
        display.setText(strDisplayValue);
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
        display.setText(strDisplayValue);
    }

    public void clean() {
        strDisplayValue = "0";
        dResultValue = 0;
        strLastAction = "";
        display.setText(strDisplayValue);
    }

    public void plus() {
        strDisplayValue = display.getText();
        dResultValue += Double.valueOf(strDisplayValue);

        System.out.printf("plus(); strDisplayValue = %s; dResultValue = %f \n", strDisplayValue, dResultValue);

        strLastAction = "+";
        strDisplayValue = "0";
        display.setText(strDisplayValue);
    }

    public void minus(){
        //todo implements minus method
        //получить введенные значения с дисплея
        strDisplayValue = display.getText();
        //если вводим данные первый раз. dResultVale = 0;
        if (strLastAction.equals("") || strLastAction.equals("=")) {
            dResultValue = Double.valueOf(strDisplayValue);
        }
        else {
            dResultValue -= Double.valueOf(strDisplayValue);
        }

        //System.out.printf("minus(); strDisplayValue = %s; dResultValue = %f \n", strDisplayValue, dResultValue);

        strLastAction = "-";
        strDisplayValue = "0";
        display.setText(strDisplayValue);
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
        //при каждом нажатии на кнопку с цифрой
        //она записывается в strDisplayValue и выводится на дисплей калькулятора
        if (strLastAction.equals("="))
            return;

        switch (strLastAction) {
            case "+":
                dResultValue += Double.valueOf(strDisplayValue);
                break;

            case "-":
                dResultValue -= Double.valueOf(strDisplayValue);
                break;
        }

        System.out.printf("equals(); strDisplayValue = %s; dResultValue = %f \n", strDisplayValue, dResultValue);

        //вывести на дисплей значение dResultValue
        strDisplayValue = String.valueOf(dResultValue);
        showValueOnDisplay();

        strLastAction = "=";
        dResultValue = 0;
        strDisplayValue = "0";
    }

    public void dot() {
        //точка может быть только одна
        if (strDisplayValue.contains(".")) {
            return;
        }

        strDisplayValue += ".";
        display.setText(strDisplayValue);
    }

    private void showValueOnDisplay() {
        if (getNumberOfDigitsAfterDot() == 0) {
            //показать на экране число без точки и нуля
            strDisplayValue = strDisplayValue.substring(0, strDisplayValue.lastIndexOf("."));
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
