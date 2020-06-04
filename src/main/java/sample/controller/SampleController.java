package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import sample.view.StageCreator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/20 22:22
 */
public class SampleController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private TabPane tabPane;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private MenuBar menuBar;


    public void initialize(URL location, ResourceBundle resources) {
        tabPane.prefWidthProperty().bind(root.widthProperty());
        scrollPane.prefHeightProperty().bind(root.heightProperty());
        menuBar.prefWidthProperty().bind(root.widthProperty());
    }

    @FXML
    private void connect(ActionEvent actionEvent) {
        StageCreator.initStage("/fxml/connect.fxml",true);
    }

    @FXML
    private void close(){
        Platform.exit();
    }
}
