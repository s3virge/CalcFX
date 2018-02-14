package sample;

public class Calculator {
    private double fResultValue = 0;

    public double clean() {
        System.out.println("Button Clean was pressed.");
        return fResultValue = 0;
    }

    public double backspace() {
        System.out.println("Button Return was pressed.");
        return 0;
    }

    private double plus(double val) {
        System.out.println("Button plus was pressed.");
        return fResultValue += val;
    }

    private double minus(double val){
        return fResultValue -= val;
    }

    private double multiply(double val) {
        return fResultValue *= val;
    }

    private double divide(double val) {
        return fResultValue /= val;
    }

    private double equals(double val) {
        return fResultValue;
    }
}
