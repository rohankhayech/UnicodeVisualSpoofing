package src.model;

/**
 * Exception thrown when a user cannot be registered.
 * 
 * A specific subclass should be thrown when appropriate.
 * @see UsernameTakenException
 * @see PasswordMismatchException
 * 
 * @author Rohan Khayech
 */
public class RegistrationException extends Exception {

    public RegistrationException() {
        super("User could not be registered.");
    }

    public RegistrationException(String message) {
        super("User could not be registered: "+message);
    }
}