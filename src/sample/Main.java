package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 270, 380);

        primaryStage.setTitle("CalcFX");
        primaryStage.setScene(scene);

        //primaryStage.getIcons().add(new Image("/icon.png"));
        //scene.getStylesheets().add(CSS);
        controller = loader.getController();

        addKeyHandler(scene);

        primaryStage.show();
    }

    private void addKeyHandler(Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.NUMPAD1 || event.getCode() == KeyCode.DIGIT1) {
                controller.keyPressed("1");
            }
            else if (event.getCode() == KeyCode.NUMPAD2 || event.getCode() == KeyCode.DIGIT2) {
                controller.keyPressed("2");
            }
            else if (event.getCode() == KeyCode.NUMPAD3 || event.getCode() == KeyCode.DIGIT3) {
                controller.keyPressed("3");
            }
            else if (event.getCode() == KeyCode.NUMPAD4 || event.getCode() == KeyCode.DIGIT4) {
                controller.keyPressed("4");
            }
            else if (event.getCode() == KeyCode.NUMPAD5 || event.getCode() == KeyCode.DIGIT5) {
                controller.keyPressed("5");
            }
            else if (event.getCode() == KeyCode.NUMPAD6 || event.getCode() == KeyCode.DIGIT6) {
                controller.keyPressed("6");
            }
            else if (event.getCode() == KeyCode.NUMPAD7 || event.getCode() == KeyCode.DIGIT7) {
                controller.keyPressed("7");
            }
            else if (event.getCode() == KeyCode.NUMPAD8 || event.getCode() == KeyCode.DIGIT8) {
                controller.keyPressed("8");
            }
            else if (event.getCode() == KeyCode.NUMPAD9 || event.getCode() == KeyCode.DIGIT9) {
                controller.keyPressed("9");
            }
            else if (event.getCode() == KeyCode.NUMPAD0 || event.getCode() == KeyCode.DIGIT0) {
                controller.keyPressed("0");
            }
            else if (event.getCode() == KeyCode.ADD) {
                controller.keyPressed("+");
            }
            else if (event.getCode() == KeyCode.SUBTRACT) {
                controller.keyPressed("-");
            }
            else if (event.getCode() == KeyCode.MULTIPLY) {
                controller.keyPressed("*");
            }
            else if (event.getCode() == KeyCode.DIVIDE) {
                controller.keyPressed("/");
            }
            else if (event.getCode() == KeyCode.ENTER) {
                controller.keyPressed("=");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
