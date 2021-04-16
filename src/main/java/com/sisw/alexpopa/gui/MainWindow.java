package com.sisw.alexpopa.gui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * @author Alex Daniel Popa
 */
public class MainWindow {


    public static BorderPane createBorderPane() {

        BorderPane borderPane = new BorderPane();
        borderPane.getStyleClass().add("bg-blue");
        borderPane.setPadding(new Insets(10)); // in pixels

        Label top = createLabel("Top panel", "bg-yellow");
        borderPane.setTop(top);

        Label center = createLabel("Center panel", "bg-gold");
        borderPane.setCenter(center);

        return borderPane;

    }

    private static Label createLabel(String labelText, String styleClass) {
        Label label = new Label(labelText);
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        BorderPane.setMargin(label, new Insets(5));
        label.getStyleClass().add(styleClass);
        return label;
    }
}
