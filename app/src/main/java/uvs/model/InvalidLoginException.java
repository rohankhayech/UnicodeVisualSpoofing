/*
 * Copyright (c) 2020 Rohan Khayech 
 */

package uvs.model;

/**
 * Exception thrown when a user cannot be logged in.
 * 
 * @author Rohan Khayech
 */
public class InvalidLoginException extends Exception {

    private static final long serialVersionUID = -6892014137707287833L;

    public InvalidLoginException() {
        super("Invalid username or password.");
    }

    public InvalidLoginException(String message) {
        super("Invalid login: "+message);
    }
}