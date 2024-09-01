import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class FileManager extends Application {

    private TreeView<String> directoryTree;
    private ListView<String> fileList;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Manager");

        BorderPane root = new BorderPane();
        directoryTree = new TreeView<>(createTree());
        fileList = new ListView<>();

        Button openButton = new Button("Open");
        Button deleteButton = new Button("Delete");

        openButton.setOnAction(e -> openFile());
        deleteButton.setOnAction(e -> deleteFile());

        root.setLeft(directoryTree);
        root.setCenter(fileList);
        root.setBottom(openButton);
        root.setBottom(deleteButton);

        directoryTree.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                loadFiles(newVal.getValue());
            }
        });

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TreeItem<String> createTree() {
        File rootDir = new File(System.getProperty("user.home"));
        TreeItem<String> rootItem = new TreeItem<>(rootDir.getName());
        rootItem.setExpanded(true);
        addDirectories(rootDir, rootItem);
        return rootItem;
    }

    private void addDirectories(File dir, TreeItem<String> parentItem) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    TreeItem<String> dirItem = new TreeItem<>(file.getName());
                    parentItem.getChildren().add(dirItem);
                    addDirectories(file, dirItem);
                }
            }
        }
    }

    private void loadFiles(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files != null) {
            fileList.getItems().clear();
            for (File file : files) {
                if (file.isFile()) {
                    fileList.getItems().add(file.getName());
                }
            }
        }
    }

    private void openFile() {
        String selectedFile = fileList.getSelectionModel().getSelectedItem();
        if (selectedFile != null) {
            try {
                File file = new File(directoryTree.getSelectionModel().getSelectedItem().getValue(), selectedFile);
                if (file.exists()) {
                    java.awt.Desktop.getDesktop().open(file);
                }
            } catch (IOException e) {
                showAlert(AlertType.ERROR, "Error", "Could not open file.");
            }
        }
    }

    private void deleteFile() {
        String selectedFile = fileList.getSelectionModel().getSelectedItem();
        if (selectedFile != null) {
            File file = new File(directoryTree.getSelectionModel().getSelectedItem().getValue(), selectedFile);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    showAlert(AlertType.ERROR, "Error", "Could not delete file.");
                } else {
                    loadFiles(directoryTree.getSelectionModel().getSelectedItem().getValue());
                }
            }
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
