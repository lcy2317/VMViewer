package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.core.data.RunTimeData;
import sample.core.entity.ConnectionData;
import sample.core.utils.PathConst;
import sample.core.utils.SerializeUtil;
import sample.view.StageCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main extends Application {

    private RunTimeData runTimeData = RunTimeData.getInstences();


    @Override
    public void start(Stage primaryStage) throws Exception {
        //加载本地数据
        List<ConnectionData> list = new ArrayList<>();
        list.add(Optional.ofNullable(new SerializeUtil<ConnectionData>().deserialize(PathConst.CONNECTION_DATA_PATH)).orElseGet(() -> {
            ConnectionData connection = new ConnectionData();
            connection.setAlias("localhost");
            connection.setHost("localhost");
            return connection;
        }));
        runTimeData.setConnectionList(list);
        System.out.println(runTimeData.getConnectionList().get(0).getAlias());


        //加载界面信息
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("VMViewer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StageCreator.initStage("/fxml/connect.fxml", true);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
