/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import src.model.Forum;
import src.model.Post;

/**
 * FXML Controller class
 *
 * @author Jayden Tan
 */

    public class ForumController implements Initializable 
    {
    
        App app;
        Forum forum;
        List<Post> postList;
        
        @FXML
        private TextField postField;
    
        @FXML
        private Button postButton;
    
        @FXML
        private TextField forumField;
    
        @FXML
        void handlePost(ActionEvent event) {
            try {
                app.publishPost(postField.getText());
                postList = forum.getPosts();
                for (Post post: postList)
                {
                    forumField.setText(post.getBody());
                }
            } catch (UnauthorizedUserException e) {
                e.printStackTrace();
            }
        }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setApp(App app) {
        this.app = app;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
    
}
