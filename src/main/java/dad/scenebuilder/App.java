package dad.scenebuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    private Controller controller;
    @Override public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        primaryStage.setTitle("CalculadoraFXML");
        primaryStage.getIcons().add(new Image("/icono.png"));
        primaryStage.setScene(new Scene(controller.getView()));
        primaryStage.setMinHeight(510);
        primaryStage.setMinWidth(510);
        primaryStage.show();
    }   
    public static void main(String[] args){
        launch(args);
    }
}