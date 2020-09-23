/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.model.Forum;
import src.view.LoginController;
/**
 *
 * @author Jayden Tan
 */
public class CCSEP extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));

        Parent root = loader.load();

        
        Forum forum = new Forum();
        App app = new App(forum);

        LoginController loginController = (LoginController) loader.getController();
        loginController.setApp(app);

        Scene scene = new Scene(root, 900, 600);
        
        stage.setTitle("Vulnerable Application");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
