package com.sisw.alexpopa;

import com.sisw.alexpopa.gui.MainWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FHM gRPC Client");

        Scene scene = new Scene(MainWindow.createScene(), 1000, 800);

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