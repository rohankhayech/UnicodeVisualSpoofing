package src.model;

/**
 * Exception thrown when a user cannot be registered as the username is already taken.
 * 
 * Superclass can be caught to handle this exception in the UI.
 * @see RegistrationException
 * 
 * @author Rohan Khayech
 */
public class UsernameTakenException extends RegistrationException {

    private static final long serialVersionUID = 1375173284391065687L;

    public UsernameTakenException() {
        super("Username already taken.");
    }

    public UsernameTakenException(String message) {
        super(message);
    }
}