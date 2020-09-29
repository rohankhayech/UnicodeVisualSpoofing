package src.model;

/**
 * Exception thrown when a user cannot be registered as the username or password is blank.
 * 
 * Superclass can be caught to handle this exception in the UI.
 * @see RegistrationException
 * 
 * @author Rohan Khayech
 */
public class EmptyFieldException extends RegistrationException {

    private static final long serialVersionUID = -2011965152103630911L;

    public EmptyFieldException() {
        super("Username and password must not be blank.");
    }

    public EmptyFieldException(String message) {
        super(message);
    }
}