package com.ajie.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main_fxml/sample.fxml"));
        primaryStage.setTitle("内⽹横向移动⼯具箱 v1.0   by private null");
        primaryStage.setScene(new Scene(root, 738, 431));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
