package com.sisw.alexpopa.gui;

import com.sisw.alexpopa.gui.scene.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class GuiMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FHM gRPC Client");

        Scene scene = new Scene(MainScene.createScene(), 1000, 800);

        // Loading stylesheet
        String styleSheet = getClass().getResource("/css/style.css").toExternalForm();
        scene.getStylesheets().add(styleSheet);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}