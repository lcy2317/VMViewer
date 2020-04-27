package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.StageCreator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("VMViewer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        StageCreator.initStage("/fxml/connect.fxml",true);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
