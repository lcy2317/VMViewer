package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import sample.core.entity.JavaProcess;
import sample.core.parser.JpsResolver;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/23 21:37
 */
public class ConnectController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<JavaProcess> tableView;
    @FXML
    private TableColumn<JavaProcess,String> pathCol;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.prefWidthProperty().bind(root.widthProperty());
        pathCol.prefWidthProperty().bind(root.widthProperty());
        tableView.getItems().addAll(JpsResolver.getJpsList());
    }
}
