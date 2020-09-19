package src.model;

/**
 * The user class represents a registered user of the web forum application.
 * 
 * Stores the user's username and password.
 * 
 * @author Rohan Khayech
 */
public class User {

    /** The user's name. Unique and not case-sensitive. */
    private String username;
    /** The user's password. Stored in plaintext for demonstration purposes. */
    private String password;

    /**
     * Constructs a new User object.
     * 
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return The user's name.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's name.
     * 
     * @param username The user's name.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Checks if the given password matches the user's password.
     * @param password The password to compare.
     * @return {@code true} if the password matches, {@code false} otherwise.
     */
    public boolean passwordMatches(String password) {
        if (password == this.password){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the user's password.
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }

   
}