/*
 * Copyright (c) 2020 Jayden Tan, Rohan Khayech 
 */
package uvs.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uvs.controller.App;
import uvs.controller.UnauthorizedUserException;
import uvs.model.Forum;
import uvs.model.Post;

/**
 * FXML Controller class
 *
 * @author Jayden Tan
 * @author Rohan Khayech
 */

public class ForumController implements Initializable {

    App app;
    Forum forum;
    List<Post> postList;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextArea postField;

    @FXML
    private Button postButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Text forumField;

    @FXML
    void handlePost(ActionEvent event) {
        try {
            app.publishPost(postField.getText());
            updatePostList();
            postField.clear();
        } catch (UnauthorizedUserException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        app.logout();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { }
    
    public void setApp(App app) {
        this.app = app;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public void setup() {
        usernameLabel.setText("Logged in as " + app.getCurrentUser());
        updatePostList();
    }

    private void updatePostList() {
        String postStr = "";
        postList = forum.getPosts();
        for (Post post : postList) {
            postStr = post.toString()+"\n\n"+postStr; 
        }
        forumField.setText(postStr);
    }
    
}
