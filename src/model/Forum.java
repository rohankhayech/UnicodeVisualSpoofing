package model;

import java.util.*;

/**
 * The Forum class stores the registered users and posts published on the site.
 */
public class Forum {
    /** List of all the registered users on the forum. */
    List<User> users;
    /** List of all the published posts on the forum. */
    List<Post> posts;

    /**
     * Constructs a new forum object.
     */
    public Forum() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Registers a new user on the forum.
     * @param username username
     * @param password
     */
    public void addUser(String username, String password) throws UsernameTakenException {
        if (!userExists(username)) {
            User u = new User(username,password);
            users.add(u);
        } else {
        }
    }

    /**
     * Checks whether a user with the specified username exists. Not case-sensitive.
     * @param username The username to check.
     * @return {@code true} if the user exists, {@code false} otherwise.
     */
    private boolean userExists(String username) {
        for (User u : users) {
            if (u.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
