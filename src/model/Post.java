package model;

/**
 * The Post class represents a user's post on the web forum.
 * 
 * @author Rohan Khayech
 */

public class Post {

    /** The user who published the post. */
    private User author;

    /** Body text of the post.
     *  In the vulnerable app this is stored exactly as entered. */
    private String body;

    /**
     * Constructs a new Post object.
     * @param author The user publishing the post.
     * @param body The body text of the post.
     */
    public Post(User author, String body) {
        this.author = author;
        this.body = body;
    }

    /**
     * @return The user who published the post.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the post's author.
     * @param author The user who published the post.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * @return The body text of the post.
     */
    public String getBody() {
        return body;
    }

    /**
     * Set's the body text of the post.
     * @param body The body text of the post.
     */
    public void setBody(String body) {
        this.body = body;
    }

    
}
