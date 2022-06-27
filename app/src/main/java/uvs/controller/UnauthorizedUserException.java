/*
 * Copyright (c) 2020 Rohan Khayech 
 */

package uvs.controller;

/**
 * Exception thrown when an operation involving the logged in user is performed without a user currently logged in.
 * 
 * @author Rohan Khayech
 */
public class UnauthorizedUserException extends Exception {

    private static final long serialVersionUID = -1966547855919386757L;

    public UnauthorizedUserException() {
        super("Invalid username or password.");
    }

    public UnauthorizedUserException(String message) {
        super("Invalid login: "+message);
    }
}