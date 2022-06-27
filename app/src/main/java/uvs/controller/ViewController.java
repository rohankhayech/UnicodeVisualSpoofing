/*
 * Copyright (c) 2020 Jayden Tan
 */

package uvs.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uvs.model.Forum;
import uvs.view.LoginController;

/**
 * Class responsible for initializing the view and opening the windowed application.
 * @author Jayden Tan
 */
public class ViewController extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../login.fxml"));

        Parent root = loader.load();

        
        Forum forum = new Forum();
        App app = new App(forum);

        LoginController loginController = (LoginController) loader.getController();
        loginController.setApp(app);
        loginController.setForum(forum);

        Scene scene = new Scene(root, 900, 600);
        
        stage.setTitle("Login (Vulnerable)");
        stage.setScene(scene);
        stage.show();

    }

    public static void open(String[] args) {
        launch(args);
    }
    
}
