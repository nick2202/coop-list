package de.nick2202.cooplist.backend.exceptions;

public class PatternMismatchException extends Exception {
    public PatternMismatchException() {
        super("Does not match pattern");
    }

    public PatternMismatchException(String message) {
        super(message);
    }
}
