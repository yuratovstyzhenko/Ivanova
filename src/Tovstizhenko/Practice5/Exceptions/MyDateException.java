package Tovstizhenko.Practice5.Exceptions;

public class MyDateException extends Exception {
    private static String ERROR_MESSAGE="Please enter correct Date string.";
    public MyDateException() {
        super(ERROR_MESSAGE);
    }
}
