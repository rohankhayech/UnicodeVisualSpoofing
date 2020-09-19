package model;

/**
 * Exception thrown when a user cannot be registered.
 * 
 * A specific subclass should be thrown when appropriate.
 * @see UsernameTakenException
 * @see PasswordMismatchException
 */
public class RegistrationException extends Exception {

    public RegistrationException() {
        super();
    }

    public RegistrationException(String message) {
        super(message);
    }
}