package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import sample.core.entity.ConnectionData;
import sample.core.entity.JavaProcess;
import sample.core.parser.JpsResolver;
import sample.core.utils.PathConst;
import sample.core.utils.SerializeUtil;
import sample.view.StageCreator;

import java.net.URL;
import java.util.*;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/20 22:22
 */
public class SampleController implements Initializable {
    @FXML
    public TableView<ConnectionData> tableView;
    @FXML
    public TableColumn alias;
    @FXML
    public Label count;
    @FXML
    public TableView<JavaProcess> tableViewProcess;
    @FXML
    public TableColumn pathCol;
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
        //主机列表
        alias.prefWidthProperty().bind(scrollPane.widthProperty());
        tableView.prefWidthProperty().bind(scrollPane.widthProperty());
        //进程列表
        tableViewProcess.prefWidthProperty().bind(scrollPane.widthProperty());
        pathCol.prefWidthProperty().bind(scrollPane.widthProperty());
        //刷新数据
        refush();
    }


    @FXML
    private void connect(ActionEvent actionEvent) {
        StageCreator.initStage("/fxml/connect.fxml",true);
    }

    @FXML
    private void close(){
        Platform.exit();
    }

    @FXML
    public void refush() {
        List<JavaProcess> list = JpsResolver.getJpsList();
        list.sort(Comparator.comparingInt(o -> o.getPath().hashCode()));
        tableViewProcess.getItems().clear();
        tableViewProcess.getItems().addAll(list);
        System.out.println(list.size());
        count.setText(list.size()+"");

        List<ConnectionData> list1 = new ArrayList<>();
        list1.add(Optional.ofNullable(new SerializeUtil<ConnectionData>().deserialize(PathConst.CONNECTION_DATA_PATH)).orElseGet(() -> {
            ConnectionData connection = new ConnectionData();
            connection.setAlias("localhost");
            connection.setHost("localhost");
            return connection;
        }));
        tableView.getItems().clear();
        tableView.getItems().addAll(list1);
    }
}
