package model;

/**
 * Exception thrown when a user cannot be registered as the username is already taken.
 * 
 * Superclass can be caught to handle this exception in the UI.
 * @see RegistrationException
 */
public class UsernameTakenException extends RegistrationException {

    public UsernameTakenException() {
        super();
    }

    public UsernameTakenException(String message) {
        super(message);
    }
}