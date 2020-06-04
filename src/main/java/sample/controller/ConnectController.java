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
import sample.core.data.RunTimeData;
import sample.core.entity.JavaProcess;
import sample.core.parser.JpsResolver;

import java.net.URL;
import java.util.List;
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
    private RunTimeData runTimeData = RunTimeData.getInstences();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.prefWidthProperty().bind(root.widthProperty());
        pathCol.prefWidthProperty().bind(root.widthProperty());

        List<JavaProcess> list=  JpsResolver.getJpsList();
        tableView.getItems().addAll(list);
        runTimeData.setJavaProcess(list);

        choiceBox.getItems().addAll("1", "2");


        tableView.setRowFactory(tv -> {
           TableRow<JavaProcess> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //选中对应的线程pid
                    JavaProcess javaProcess = row.getItem();
                    runTimeData.setPid(javaProcess.getPid());
                    System.out.println(javaProcess);
                    ((Stage)root.getScene().getWindow()).close();
                }
            });
            return row;
        });


        radio1.setOnMouseClicked(event -> choiceBox.setDisable(true));
        radio2.setOnMouseClicked(event -> choiceBox.setDisable(false));
    }


}
