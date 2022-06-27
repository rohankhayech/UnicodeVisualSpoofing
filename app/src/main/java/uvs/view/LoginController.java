/*
 * Copyright (c) 2020 Jayden Tan
 */

package uvs.view;

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
import uvs.controller.App;
import uvs.model.Forum;
import uvs.model.InvalidLoginException;
import uvs.model.RegistrationException;

/**
 * FXML Controller class
 *
 * @author Jayden Tan
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
    private Text loginError;
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
    private Text registerError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}

    @FXML
    private void handleLogin(ActionEvent event) {
        // Call relevent login methods and display forum page if successful
        try {
            loginError.setText("");
            registerError.setText("");
            app.login(userLogin.getText(), passLogin.getText());
            userLogin.clear();
            passLogin.clear();

            //Loads up the forum FXML
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../forum.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                ForumController forumController = (ForumController) loader.getController();
                forumController.setApp(app);
                forumController.setForum(forum);
                forumController.setup();
                
                stage.setTitle("Forum (Vulnerable)");
                stage.setScene(scene);

                //Hide the current window
                ((Stage) loginButton.getScene().getWindow()).hide();
                
                //Open the forum window
                stage.showAndWait();

                //Reopen the window when done
                ((Stage) loginButton.getScene().getWindow()).show();

            } catch (Exception e) {
                e.printStackTrace();
                //System.err.println(e.getMessage());
            }
        } catch (InvalidLoginException e) {
            passLogin.clear();
            loginError.setText(e.getMessage());
        }
    }

    //Register Button EventListener
    @FXML
    private void handleRegister(ActionEvent event) {
        // Call registerUser() to successfully create a new user IF passwords are a match
        try {
            loginError.setText("");
            registerError.setText("");

            app.registerUser(userRegister.getText(), passRegister.getText(), confirmPassRegister.getText());
            registerError.setText("User successfully registered.");
            
            userRegister.clear();
            passRegister.clear();
            confirmPassRegister.clear();
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
