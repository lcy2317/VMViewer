package sample.controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.core.entity.ConnectionData;
import sample.core.entity.JavaProcess;
import sample.core.parser.JpsResolver;
import sample.core.utils.PathConst;
import sample.core.utils.SerializeUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/23 21:37
 */
public class ConnectController implements Initializable {
    @FXML
    public ChoiceBox<String> choiceBox;
    public JFXRadioButton radio1;
    public JFXRadioButton radio2;
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<JavaProcess> tableView;
    @FXML
    private TableColumn<JavaProcess, String> pathCol;

    private  final List<ConnectionData> connectionDataList = new ArrayList<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.prefWidthProperty().bind(root.widthProperty());
        pathCol.prefWidthProperty().bind(root.widthProperty());

        tableView.getItems().addAll(JpsResolver.getJpsList());

        choiceBox.getItems().addAll("1", "2");

        connectionDataList.add(Optional.ofNullable(new SerializeUtil<ConnectionData>().deserialize(PathConst.CONNECTION_DATA_PATH)).orElseGet(() -> {
            ConnectionData connection = new ConnectionData();
            connection.setAlias("localhost");
            connection.setHost("localhost");
            return connection;
        }));

        tableView.setRowFactory(tv -> {
            TableRow<JavaProcess> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //选中对应的线程pid
                    JavaProcess javaProcess = row.getItem();
                    //序列化所有连接信息
                    SerializeUtil<ConnectionData> util = new SerializeUtil<>();
                    util.serialize(PathConst.CONNECTION_DATA_PATH, connectionDataList);

                    System.out.println(javaProcess);
                    ((Stage) root.getScene().getWindow()).close();
                }
            });
            return row;
        });


        radio1.setOnMouseClicked(event -> choiceBox.setDisable(true));
        radio2.setOnMouseClicked(event -> choiceBox.setDisable(false));
    }


}
