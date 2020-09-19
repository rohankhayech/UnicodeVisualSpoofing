package controller;

/**
 * Exception thrown when an operation involving the logged in user is performed without a user currently logged in.
 * 
 * @author Rohan Khayech
 */
public class UnauthorizedUserException extends Exception {

    public UnauthorizedUserException() {
        super("Invalid username or password.");
    }

    public UnauthorizedUserException(String message) {
        super("Invalid login: "+message);
    }
}