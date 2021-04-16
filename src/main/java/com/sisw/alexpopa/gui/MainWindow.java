package com.sisw.alexpopa.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;

/**
 * @author Alex Daniel Popa
 */
public class MainWindow {


    public static BorderPane createScene() {

        BorderPane root = new BorderPane();
        root.getStyleClass().add("bg-blue");
        root.setPadding(new Insets(10)); // in pixels

//        Label top = createLabel("Top panel", "bg-yellow");
        HBox topPane = createButtonPane();
        root.setTop(topPane);

        Label center = createLabel("Center panel", "bg-gold");
        root.setCenter(center);

        return root;

    }

    private static HBox createButtonPane() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15,12,15,12));
        hbox.setSpacing(10);
        hbox.getStyleClass().add("bg-yellow");

        Button btnConnect = new Button("Connect to server");
        btnConnect.setPrefSize(200,20);

        Pane spacer = new Pane();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button btnDisconnect = new Button("Disconnect from server");
        btnDisconnect.setPrefSize(200,20);

        hbox.getChildren().addAll(btnConnect,spacer,btnDisconnect);

        return hbox;
    }

    private static Label createLabel(String labelText, String styleClass) {
        Label label = new Label(labelText);
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        BorderPane.setMargin(label, new Insets(5));
        label.getStyleClass().add(styleClass);
        return label;
    }

    private static Button createButton(String text, int size) {
        Button btn = new Button();
        btn.setText(text);
        btn.setFont(new Font(size));

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Connecting so server....");
            }
        });


        return btn;
    }
}
