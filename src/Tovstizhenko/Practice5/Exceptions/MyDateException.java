package Tovstizhenko.Practice5.Exceptions;

/**
 * Created by IgorPc on 12/5/2018.
 */
public class MyDateException extends Exception {
    private static String ERROR_MESSAGE="Please enter correct Date string.";
    public MyDateException() {
        super(ERROR_MESSAGE);
    }
}
