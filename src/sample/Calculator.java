package sample;

import javafx.scene.control.TextField;

public class Calculator {

    private String sValueOnDisplay; //
    //private int numberOfDigits; //сколько разрядов отображается на дисплее
    private TextField display;  //ссылка на объект поля ввода
    private double dResult = 0;
    private String sLastAction = "";

    public void initialize(TextField display) {
        this.sValueOnDisplay = display.getText();
        //this.numberOfDigits = 7;
        this.display = display;
    }

    public void append(String append) {
        //если в поле ввода сейчас цифра "0" или все разряды дисплея уже заполнены
        if (sValueOnDisplay.equals("0") ) {
            //то вместо 0 выводим цифру append
            sValueOnDisplay = append;
        }
        else {
            //иначе прибавляем к значению из поля ввода цифру append
            sValueOnDisplay += append;
        }
        //показать новое значение в поле ввода
        display.setText(sValueOnDisplay);
    }

    public void backspace() {
        //удалить последнюю цифру
        String withoutTheLast = sValueOnDisplay.substring(0, sValueOnDisplay.length()-1);
        //если убираем последний символ
        if (withoutTheLast.equals("")) {
            //то вывести на дисплей 0
            withoutTheLast = "0";
        }

        sValueOnDisplay = withoutTheLast;
        //показать новое значение
        display.setText(sValueOnDisplay);
    }

    public void clean() {
        sValueOnDisplay = "0";
        dResult = 0;
        sLastAction = "";
        display.setText(sValueOnDisplay);
    }

    /**
     * 1 + 1 + 1 + 1 + 1 = 5
     * 5 - 1 - 1 - 1 - 1 = 0
     * 5+1=6-1
     * 5-1=4-1
     * 1*1*1*1*1=1
     * 1 - 1 + 1 * 1 / 1 = 1*/

    public void operation(String op) {
        toDoLastAction();

        sLastAction = op;
        sValueOnDisplay = "0";
        display.setText(sValueOnDisplay);
    }

    public void equals() {
        //при каждом нажатии на кнопку с цифрой
        //она записывается в sValueOnDisplay и выводится на дисплей калькулятора
        if (sLastAction.equals("="))
            return;

        toDoLastAction();

        System.out.printf("equals(); sValueOnDisplay = %s; dResult = %f \n", sValueOnDisplay, dResult);

        //вывести на дисплей значение dResult
        sValueOnDisplay = String.valueOf(dResult);
        showValueOnDisplay();

        sLastAction = "=";
    }

    public void dot() {
        //точка может быть только одна
        if (sValueOnDisplay.contains(".")) {
            return;
        }

        sValueOnDisplay += ".";
        display.setText(sValueOnDisplay);
    }

    private void showValueOnDisplay() {
        //если пытались делить на 0,
        //то в equals() sValueOnDisplay == Infinity
        if (sValueOnDisplay.equals("Infinity")) {
            display.setText("Error");
            return;
        }

        if (getNumberOfDigitsAfterDot() == 0) {
            //показать на экране число без точки и нуля
            sValueOnDisplay = sValueOnDisplay.substring(0, sValueOnDisplay.lastIndexOf("."));
        }
        display.setText(sValueOnDisplay);
    }

    private int getNumberOfDigitsAfterDot() {
        int numberOfDigits = 0;
        if (sValueOnDisplay.contains(".")) {
            int index = sValueOnDisplay.indexOf('.');
            String afterDot = sValueOnDisplay.substring(index + 1);
            numberOfDigits = afterDot.length();

            //если после запятой одна цифра и эта цифра ноль
            if (numberOfDigits == 1 && afterDot.equals("0")) {
                numberOfDigits = 0;
            }
        }
        return numberOfDigits;
    }

    public void toDoLastAction() {
        switch(sLastAction) {
            case "-": dResult -= Double.valueOf(sValueOnDisplay);
                break;
            case "+": dResult += Double.valueOf(sValueOnDisplay);
                break;
            case "*": dResult *= Double.valueOf(sValueOnDisplay);
                break;
            case "/": dResult /= Double.valueOf(sValueOnDisplay);
                //если деление на ноль выполняется через переменные,
                //то исключения нет,
                //если цифрами то исключение есть
                //dResult = 10 / 0; //java.lang.ArithmeticException: / by zero
                //если делить dResult на 0, то dResult = Infinity;
                break;
            default: dResult = Double.valueOf(sValueOnDisplay);
        }
    }
}
