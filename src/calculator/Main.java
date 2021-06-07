package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        primaryStage.setTitle("Calculator");
        try {
            Image icon = new Image("file:///C:\\Development\\CacttusEducation\\GUI\\Gjenerata 2020-21\\TestJavaFX\\images\\icon.png");
            System.out.println(icon);
            primaryStage.getIcons().add(icon);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        primaryStage.setScene(new Scene(root, 325, 350));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}