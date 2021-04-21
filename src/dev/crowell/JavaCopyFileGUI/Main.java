package dev.crowell.JavaCopyFileGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("JavaCopyFileGUI");
        primaryStage.getIcons().add(new Image("META-INF/Icon16.png"));
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void CopyFile(String source, String destination) throws IOException
    {
        FileInputStream inFile = new FileInputStream(source);
        FileOutputStream outFile = new FileOutputStream(destination);

        int contents;

        while((contents = inFile.read()) != -1)
        {
            outFile.write(contents);
        }

        if(inFile != null)
        {
            inFile.close();
        }

        if(outFile != null)
        {
            outFile.close();
        }
    }
}
