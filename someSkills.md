## 用到的一些技术点
JavaFX、sceneBuilder、jps、jstat、jmap  
推荐1.使用sceneBuilder绘制页面，再在fxml中修改  
推荐2.可以用fxml实现的就不要用Java代码实现  

[toc]

### JavaFX
###### 打开一个窗口
```java
    //本质是创建新的stage并绑定scene，然后显示。scene的其他参数如主题等，可在fxml定义，此处不用写。
    public void openNewWindow(String fxmlPath) throws Exception {
        Stage stage = new Stage();
        Scene scene = new Scene(FXMLLoader.load(StageCreator.class.getResource(fxmlPath)));
        stage.setScene(scene);
        stage.show();
    }
```
###### 打开一个模态窗口
```java
    //和上面相比多了一个type选择是否为模态窗口。
    public void openNewWindow(String fxmlPath, boolean type) throws Exception {
        Stage stage = new Stage();
        if(type){
            stage.initModality(Modality.APPLICATION_MODAL);
        }
        Scene scene = new Scene(FXMLLoader.load(StageCreator.class.getResource(fxmlPath)));
        stage.setScene(scene);
        stage.show();
    }
```
###### 修改现有窗口
```java
    //本质是通过任意node节点获取stage并重新绑定scene，原先的scene会被销毁掉。
    public void resetWindow(Node root, String fxmlPath) throws Exception {
        Stage stage = (Stage) root.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(StageCreator.class.getResource(fxmlPath)));
        stage.setScene(scene);
    }
```
###### 修改左上角以及任务栏图标
```java
    public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //在你的启动类Main的start方法写这行代码
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.jpg")));
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
```
###### 创建RadioButton控件（单选按钮组）
```xml
    <!--通过定义一个ToggleGroup并将按钮绑定到上面来实现，注意$符号-->
    <fx:define>
        <ToggleGroup fx:id="myToggleGroup"/>
    </fx:define>
    <RadioButton text="radioButton1" selected="true" toggleGroup="$myToggleGroup" />
    <RadioButton text="radioButton2" disbaled="false" toggleGroup="$myToggleGroup" />
```
###### 创建TableView控件（列表）
```xml
    <!--首先创建一个tableView，然后在内部依次创建用于绑定数据的item、用于显示列表头的colums-->
    <TableView fx:id="table" >
        <items>
            <FXCollections fx:factory="observableArrayList"/>
        </items>
        <columns>
            <TableColumn text="序号">
                <cellValueFactory>
                    <PropertyValueFactory property="id"/>
                </cellValueFactory>
            </TableColumn>
        </columns>
        <columns>
            <TableColumn text="姓名">
                <cellValueFactory>
                    <PropertyValueFactory property="name"/>
                </cellValueFactory>
            </TableColumn>
        </columns>
    </TableView>
```
```java
    //然后在我们Controller的初始化方法中绑定数据
    //实现Initializable接口的initialize方法用于在创建页面时进行一些初始化操作
    //Student是一个只含有id和name以及对应get、set方法的类
    public class Controller implements Initializable {
        @FXML
        public TableView<Student> table;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
        Student student = new Student();
        student.setId("01");
        student.setName("郦铖阳");
        //add以及addAll方法可以添加单个student、student[]、以及List<Student>等
        table.getItems().add(student);
        }
    }
```
###### 创建ChoiceBox控件（下拉选择框）
```xml
    <!--首先创建一个ChoiceBox，然后在内部创建一个数据源item-->
    <!--少量数据也可以直接创建-->
    <ChoiceBox fx:id="choiceBox" >
        <items>
            <FXCollections fx:factory="observableArrayList" />
        </items>
        <String fx:value="直接创建的数据"/>
    </ChoiceBox>
```
```java
    public class Controller implements Initializable {
        @FXML
        public ChoiceBox<String> choiceBox;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //获取数据源后直接添加数据
            choiceBox.getItems().add("apple");
            choiceBox.getItems().addAll("white","black");
        }
    }
```
###### 创建MenuBar控件（菜单栏）
```xml
    <!-- 创建级联菜单栏，并添加点击事件，在controller中创建同名方法即可触发 -->
    <MenuBar>
        <menus>
            <Menu text="menu1">
                <Menu text="file" onAction="#click"/>
                <Menu text="help"/>
            </Menu>
            <Menu text="menu2"/>
        </menus>
    </MenuBar>
```
###### 创建TabPane控件（选项卡）
```xml
    <!-- 创建选项卡，每个选项卡内有独立界面，可切换 -->
    <!-- 可以通过fx:include来引用其他fxml文件，或者直接在Tab内部创建Panel。推荐第一种，便于管理 -->
    <TabPane fx:id="tabPanel">
        <Tab text="tab1">
            <fx:include source="other.fxml" />
        </Tab>
        <Tab text="tab2">
            <AnchorPane>
                <Label fx:id="label"></Label>
            </AnchorPane>
        </Tab>
    </TabPane>
```
###### 插入图片
```xml
    <!--创建图片并设置大小，注意@符号。设置大小时注意布局方式-->
    <ImageView fitWidth="100" fitHeight="100">
            <Image url="@icon.jpg"/>
    </ImageView>
```
###### 长宽绑定
```java
    public class Controller implements Initializable {
        @FXML
        public AnchorPane root;
        @FXML
        public TableView<Student> table;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //table的宽度绑定为父组件的宽度，当父组件被拉伸时子组件可以同步变化
            table.prefWidthProperty().bind(root.widthProperty());
        }
    }
```
