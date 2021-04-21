package dev.crowell.JavaCopyFileGUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    private TextField sourceEntry;

    @FXML
    private TextField destinationEntry;

    @FXML
    public void OnSourceButtonClicked()
    {
        try
        {
            FileChooser sourceChooser = new FileChooser();
            sourceEntry.setText(sourceChooser.showOpenDialog(null).getAbsolutePath());
        }
        catch(RuntimeException e)
        {
            // Do a lot of nothing here...
        }
    }

    @FXML
    public void OnDestinationButtonClicked()
    {
        FileChooser destinationChooser = new FileChooser();
        try
        {
            destinationEntry.setText(destinationChooser.showOpenDialog(null).getAbsolutePath());
        }
        catch(RuntimeException e)
        {
            // Do nothing at all...
        }
    }

    @FXML
    public void OnOKClicked()
    {
        try
        {
            Main.CopyFile(sourceEntry.getText(), destinationEntry.getText());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Platform.exit();
    }

    @FXML
    public void OnCancelClicked()
    {
        Platform.exit();
    }

    @FXML
    public void OnCopyClicked()
    {
        try
        {
            Main.CopyFile(sourceEntry.getText(), destinationEntry.getText());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
