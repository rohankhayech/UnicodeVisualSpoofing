package src.model;

import java.net.IDN;
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
            String filteredBody = filterIDNs(body);
            Post p = new Post(author,filteredBody); // Patched app converts URLs in post text to punycode.
            posts.add(p);
        }
    } 

    /**
     * Detects any Internationalized Domain Names in the given string and converts them to punycode.
     * Unicode characters that are not part of a URL will remain without conversion.
     * @param str The string to filter.
     * @return The filtered string.
     */
    public String filterIDNs(String str) {
        String filteredStr="";
        String[] words = str.split(" ");
        for(String word : words) {
            //detect if word is a website
            if (word.contains("www.") 
                || word.contains("http://") 
                || word.contains("https://") 
                || word.contains(".co") //.co, .com
                || word.contains(".org")
                || word.contains(".net")
                || word.contains(".org")
                || word.contains(".info"))
                //more prefixes/suffixes could be added here as needed
            {
                filteredStr += IDN.toASCII(word, IDN.ALLOW_UNASSIGNED) + " "; //convert IDN to punycode format
            } else {
                filteredStr += word + " ";  //allow unicode characters if not part of a URL
            }
        }
        return filteredStr;
    }
}
