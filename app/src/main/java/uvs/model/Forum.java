package uvs.model;

import java.util.*;

/**
 * The Forum class stores the registered users and posts published on the site.
 * 
 * @author Rohan Khayech
 */
public class Forum {
    /** List of all the registered users on the forum. */
    private List<User> users;
    /** List of all the published posts on the forum. */
    private List<Post> posts;

    /**
     * Constructs a new forum object.
     */
    public Forum() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    /**
     * @return List of all the published posts on the forum.
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Registers a new user on the forum.
     * @param username The new user's name.
     * @param password The new user's password.
     * @throws UsernameTakenException When the given username is already taken by an existing user.
     */
    public void addUser(String username, String password) throws UsernameTakenException {
        if (!userExists(username)) {
            User u = new User(username,password);
            users.add(u);
        } else {
            throw new UsernameTakenException("Username already taken.");
        }
    }

    /**
     * Checks whether a user with the specified username exists. Not case-sensitive.
     * @param username The username to check.
     * @return {@code true} if the user exists, {@code false} otherwise.
     */
    public boolean userExists(String username) {
        for (User u : users) {
            if (u.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the user with the specified username if exists.
     * @param username The username to find.
     * @return The User if found, {@code null} otherwise.
     */
    private User findUser(String username) {
        for (User u : users) {
            if (u.getUsername().toLowerCase().equals(username.toLowerCase())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Provides a user login if the username is valid and the password matches.
     * 
     * @param username The input username.
     * @param password The input password.
     */
    public User provideLogin(String username, String password) throws InvalidLoginException {
        User user = findUser(username);
        if (user == null) {
            throw new InvalidLoginException("User does not exist.");
        } else {
            if (!user.passwordMatches(password)) {
                throw new InvalidLoginException("Password incorrect.");
            }
        }
        return user;
    }

    /**
     * Adds a post to the forum. 
     * If the user isn't registered this function will not add a post.
     * @param author The author of the new post.
     * @param body The body text of the new post.
     */
    public void addPost(User author, String body) {
        if (users.contains(author)) {
            Post p = new Post(author,body); // Vulnerable app performs no sanitization/conversion of post text.
            posts.add(p);
        }
    } 
}
