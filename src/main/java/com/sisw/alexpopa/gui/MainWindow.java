package com.sisw.alexpopa.gui;

import com.sisw.alexpopa.model.FileEntry;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Alex Daniel Popa
 */
public class MainWindow {

    private static ObservableList<FileEntry> fileEntries;
    private static TableView<FileEntry> tableOfFileEntry;

    public static BorderPane createScene() {

        BorderPane root = new BorderPane();
        root.getStyleClass().add("bg-blue");
        root.setPadding(new Insets(10)); // in pixels

//        Label top = createLabel("Top panel", "bg-yellow");
        HBox topPane = createButtonPane();
        root.setTop(topPane);

//        Label center = createLabel("Center panel", "bg-gold");
//        root.setCenter(center);

        createTable();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(0,12,0,12));
        vBox.getChildren().addAll(tableOfFileEntry);
        root.setCenter(vBox);

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

        Button btnAddElements = new Button("add 3 elements");
        btnAddElements.setPrefSize(200,20);
        btnAddElements.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addElementsRefreshTable();
            }
        });


        hbox.getChildren().addAll(btnConnect,spacer,btnDisconnect,btnAddElements);

        return hbox;
    }

    private static void addElementsRefreshTable() {
        generateFileEntry(3);
        tableOfFileEntry.setItems(fileEntries);
        tableOfFileEntry.refresh();
    }

    private static void createTable() {
        tableOfFileEntry = new TableView<>();

        //id Column
        TableColumn<FileEntry, Long> colId = new TableColumn<>("ID");
        colId.setMinWidth(100);
        colId.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getId()).asObject());

        //filename Column
        TableColumn<FileEntry, String> colFilename = new TableColumn<>("Filename");
        colFilename.setMinWidth(100);
        colFilename.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFilename()));

        //eventKind Column
        TableColumn<FileEntry, String> colEventKind = new TableColumn<>("Event Kind");
        colEventKind.setMinWidth(100);
        colEventKind.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventKind()));

        //id Column
        TableColumn<FileEntry, String> colOperationDateTme = new TableColumn<>("Operation DateTme");
        colOperationDateTme.setMinWidth(100);
        colOperationDateTme.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOperationDateTme()));

        //id Column
        TableColumn<FileEntry, Long> colFileDetailsId = new TableColumn<>("FileDetailsId");
        colFileDetailsId.setMinWidth(100);
        colFileDetailsId.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getFileDetailsId()).asObject());

        //id Column
        TableColumn<FileEntry, String> colExtension = new TableColumn<>("Extension");
        colExtension.setMinWidth(100);
        colExtension.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExtension()));

        //id Column
        TableColumn<FileEntry, Long> colSize = new TableColumn<>("Size");
        colSize.setMinWidth(100);
        colSize.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getSize()).asObject());

        //id Column
        TableColumn<FileEntry, String> colCreationDate = new TableColumn<>("CreationDate");
        colCreationDate.setMinWidth(100);
        colCreationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCreationDate()));

        //id Column
        TableColumn<FileEntry, String> colModificationDate = new TableColumn<>("ModificationDate");
        colModificationDate.setMinWidth(100);
        colModificationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModificationDate()));

        getFileEntry();
        tableOfFileEntry.setItems(fileEntries);
        tableOfFileEntry.getColumns().addAll(
                colId,
                colFilename,
                colEventKind,
                colOperationDateTme,
                colFileDetailsId,
                colExtension,
                colSize,
                colCreationDate,
                colModificationDate);
    }

    private static void getFileEntry() {
        fileEntries = FXCollections.observableArrayList();
        generateFileEntry(30);
    }

    private static void generateFileEntry(int size) {

        List<String> eventKindList = new ArrayList<String>();
        eventKindList.add("ENTRY_CREATE");
        eventKindList.add("ENTRY_DELETE");

        for(int i = 1; i <= size; i++) {
            Collections.shuffle(eventKindList);

            FileEntry fileEntry = new FileEntry();
            fileEntry.setId((long) (Math.random() * (1000L - 1L)));
            fileEntry.setFilename("filename-" + i + ".txt");
            fileEntry.setEventKind(eventKindList.get(0));
            fileEntry.setOperationDateTme(Instant.now().toString());

            if(fileEntry.getEventKind().equals("ENTRY_CREATE")) {
                fileEntry.setFileDetailsId((long) (Math.random() * (1000L - 1L)));
                fileEntry.setExtension("txt");
                fileEntry.setSize((long) (Math.random() * (1000L - 500L)));
                fileEntry.setCreationDate(Instant.now().toString());
                fileEntry.setModificationDate(Instant.now().toString());
            }

            fileEntries.add(fileEntry);
        }
    }

//    private static Label createLabel(String labelText, String styleClass) {
//        Label label = new Label(labelText);
//        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
//        BorderPane.setMargin(label, new Insets(5));
//        label.getStyleClass().add(styleClass);
//        return label;
//    }
//
//    private static Button createButton(String text, int size) {
//        Button btn = new Button();
//        btn.setText(text);
//        btn.setFont(new Font(size));
//
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Connecting so server....");
//            }
//        });
//
//
//        return btn;
//    }
}
