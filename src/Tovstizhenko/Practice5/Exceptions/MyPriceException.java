package Tovstizhenko.Practice5.Exceptions;

/**
 * Created by IgorPc on 12/5/2018.
 */
public class MyPriceException extends Exception {
    private static String ERROR_MESSAGE="Please enter positive price";
    public MyPriceException() {
        super(ERROR_MESSAGE);
    }
}
