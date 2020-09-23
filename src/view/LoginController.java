/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import src.controller.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author student
 */
public class LoginController implements Initializable {

    App app;

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
    private void handleLogin()
    {
        //Call relevent login methods and display forum
            
            //app.login()
    } 

    public void setApp(App app) {
        this.app = app;
    }
    
    
}
