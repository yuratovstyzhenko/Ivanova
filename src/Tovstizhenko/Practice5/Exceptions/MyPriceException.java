package Tovstizhenko.Practice5.Exceptions;

public class MyPriceException extends Exception {
    private static String ERROR_MESSAGE="Please enter positive price";
    public MyPriceException() {
        super(ERROR_MESSAGE);
    }
}
