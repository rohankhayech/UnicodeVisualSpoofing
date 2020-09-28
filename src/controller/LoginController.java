/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.model.Forum;
//import src.controller.App;
import src.model.InvalidLoginException;
import src.model.RegistrationException;

/**
 * FXML Controller class
 *
 * @author student
 */
public class LoginController implements Initializable {

    App app;
    Forum forum;

    @FXML
    private Text userText;
    @FXML
    private Text passText;
    @FXML
    private TextField userLogin;
    @FXML
    private TextField passLogin;
    @FXML
    private Button loginButton;
    @FXML
    private TextField loginError;
    @FXML
    private Button registerButton;
    @FXML
    private Text userRegisterText;
    @FXML
    private TextField userRegister;
    @FXML
    private TextField passRegister;
    @FXML
    private TextField confirmPassRegister;
    @FXML
    private TextField registerError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        // Call relevent login methods and display forum page if successful
        try {
            app.login(userLogin.getText(), passLogin.getText());
            //Loads up the forum FXML
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("forum.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                ForumController forumController = (ForumController) loader.getController();
                forumController.setApp(app);
                forumController.setForum(forum);
                
                stage.setTitle("Forum (Vulnerable)");
                stage.setScene(scene);
                stage.show();
                
            } catch (Exception e) {
                e.printStackTrace();
                //System.err.println(e.getMessage());
            }
        } catch (InvalidLoginException e) {
            loginError.setText(e.getMessage());
        }
    }

    //Register Button EventListener
    @FXML
    private void handleRegister(ActionEvent event) {
        // Call registerUser() to successfully create a new user IF passwords are a match
        try {
            app.registerUser(userRegister.getText(), passRegister.getText(), confirmPassRegister.getText());
            registerError.setText("User successfully registered.");
        } catch (RegistrationException e) {
            registerError.setText(e.getMessage());
        }    
        
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
    
    
}
