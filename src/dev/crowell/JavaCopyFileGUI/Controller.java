package dev.crowell.JavaCopyFileGUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button browseDestination;

    @FXML
    private Button browseSource;

    @FXML
    private Button copyButton;

    @FXML
    private void initialize()
    {
        copyButton.setDisable(true);
    }
    @FXML
    public void OnKeyReleased()
    {
        boolean isDisabled = sourceEntry.getText().isEmpty() || sourceEntry.getText().strip().isEmpty()
                || destinationEntry.getText().isEmpty() || destinationEntry.getText().strip().isEmpty();

        copyButton.setDisable(isDisabled);

    }

    @FXML
    public void OnBrowseButtonClicked(ActionEvent event)
    {
        FileChooser choice = new FileChooser();

        if(event.getSource().equals(browseSource))
        {
            sourceEntry.setText(choice.showOpenDialog(null).getAbsolutePath());
        }

        if(event.getSource().equals(browseDestination))
        {
            destinationEntry.setText(choice.showOpenDialog(null).getAbsolutePath());
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
