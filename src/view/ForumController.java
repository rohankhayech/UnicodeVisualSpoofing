/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import src.controller.App;
import src.model.Forum;

/**
 * FXML Controller class
 *
 * @author Jayden Tan
 */
public class ForumController implements Initializable {


    App app;
    Forum forum;

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
