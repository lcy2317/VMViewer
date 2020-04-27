package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/23 22:27
 */
public class StageCreator {
    //创建默认新窗口
    public static void initStage(String fxmlPath) {
        try {
            createStage(fxmlPath, new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建默认参数新窗口 false：非模态 true：模态
    public static void initStage(String fxmlPath, boolean type)  {
        Stage stage = new Stage();
        if(type){
            stage.initModality(Modality.APPLICATION_MODAL);
        }
        createStage(fxmlPath, stage);
    }

    private static void createStage(String fxmlPath, Stage stage)  {
        try {
            stage.setScene(new Scene(FXMLLoader.load(StageCreator.class.getResource(fxmlPath))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }


    //切换stage的Sence,销毁之前的sence
    public static void resetSence(Node root, String fxmlPath) throws Exception {
        Stage stage = (Stage) root.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(StageCreator.class.getResource(fxmlPath)));
        stage.setScene(scene);
    }
}
