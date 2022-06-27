package uvs.model;

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

    private static final long serialVersionUID = 241018796766212949L;

    public RegistrationException() {
        super("User could not be registered.");
    }

    public RegistrationException(String message) {
        super("User could not be registered: "+message);
    }
}