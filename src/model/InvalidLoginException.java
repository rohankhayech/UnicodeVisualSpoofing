package model;

/**
 * Exception thrown when a user cannot be logged in.
 * 
 * @author Rohan Khayech
 */
public class InvalidLoginException extends Exception {

    public InvalidLoginException() {
        super("Invalid username or password.");
    }

    public InvalidLoginException(String message) {
        super("Invalid login: "+message);
    }
}