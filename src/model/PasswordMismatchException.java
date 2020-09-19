package model;

/**
 * Exception thrown when a user cannot be registered as the password does not match the confirmed password.
 * 
 * Superclass can be caught to handle this exception in the UI.
 * @see RegistrationException
 */
public class PasswordMismatchException extends RegistrationException {

    public PasswordMismatchException() {
        super();
    }

    public PasswordMismatchException(String message) {
        super(message);
    }
}