package src.controller;

import src.model.Forum;
import src.model.InvalidLoginException;
import src.model.PasswordMismatchException;
import src.model.RegistrationException;
import src.model.User;

public class App {
    /** The forum object the app will interact with. */
    private Forum forum;
    /** The currently logged in user. {@code null} if there is no user logged in. */
    private User currentUser;

    /**
     * Constructs the app.
     * @param forum The forum object for the app to interact with.
     */
    public App(Forum forum)
    {
        this.forum = forum;
        this.currentUser = null;
    }

    /**
     * Logs into the app using the specified username and password if valid.
     * @param username The input username.
     * @param password The input password.
     * @throws InvalidLoginException If the username or password is invalid.
     */
    public void login(String username, String password) throws InvalidLoginException {
        currentUser = forum.provideLogin(username, password);
    }

    /**
     * Logs out of the app.
     */
    public void logout() {
        currentUser = null;
    }

    /**
     * Publishes a post as the currently logged in user.
     * @param body The body text of the post to add.
     * @throws UnauthorizedUserException If there is no user logged in.
     */
    public void publishPost(String body) throws UnauthorizedUserException {
        if (currentUser!=null) {
            forum.addPost(currentUser,body);
        } else {
            throw new UnauthorizedUserException();
        }
    }

    /**
     * Registers a user on the forum. 
     * 
     * @param username Name of the new user.
     * @param password Password for the new user.
     * @param confirmPassword Confirmation of new password.
     * @throws RegistrationException If the username is taken or passwords don't match.
     */
    public void registerUser(String username, String password, String confirmPassword) throws RegistrationException {
        if (password.equals(confirmPassword)) {    
            forum.addUser(username, password);
        } else {
            throw new PasswordMismatchException();
        }
    }

    /**
     * @return The username of the currently logged in user or {@code null} if logged out.
     */
    public String getCurrentUser() {
        String name = null;
        if (currentUser != null) {
            name = currentUser.getUsername();
        }
        return name;
    }

}
