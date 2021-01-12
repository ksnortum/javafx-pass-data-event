package net.snortum.javafx.event;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));

        Text text = new Text("Initial state");
        text.addEventFilter(ProgressEvent.PROGRESS, progressEvent ->
                text.setText(Integer.toString(progressEvent.getThusFar())));

        Button startButton = new Button("Start");
        startButton.setOnMouseClicked(event -> {
            Task<Void> voidTask = new Task<>() {
                @Override
                protected Void call() {
                    new BackgroundTask().startTask(text);
                    return null;
                }
            };
            voidTask.setOnSucceeded(workerEvent -> System.out.println("Task succeeded"));
            voidTask.setOnFailed(workerEvent -> {
                Throwable error = workerEvent.getSource().getException();
                System.out.println(error);
                StackTraceElement[] errs = error.getStackTrace();
                Arrays.asList(errs).forEach(System.out::println);
            });
            Thread thread = new Thread(voidTask);
            thread.setDaemon(true);
            thread.start();
        });

        hBox.getChildren().addAll(startButton, text);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }
}
