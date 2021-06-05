package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sampleVBox.fxml"));



//        //Pane, Box -> e kuptimin dicka si Layout -> div ne html
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setHgap(10);//margin -> hapesire e zbrazet
//        root.setVgap(10);
//
//        Label greeting = new Label("Cka ka, cka ska!");
//        root.getChildren().add(greeting);


        primaryStage.setTitle("JavaFX ICT");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
