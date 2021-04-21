package dev.crowell.JavaCopyFileGUI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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
        File filename = choice.showOpenDialog(null);
        if(filename != null)
        {

            if (event.getSource().equals(browseSource))
            {
                sourceEntry.setText(filename.getAbsolutePath());
            }

            if (event.getSource().equals(browseDestination))
            {
                destinationEntry.setText(filename.getAbsolutePath());
            }
        }
    }

    @FXML
    public void OnOKClicked()
    {
            if(!copyButton.isDisabled())
            {
                OnCopyClicked();
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
        Runnable task = new Runnable()
        {

            @Override
            public void run()
            {
                try
                {
                    Main.CopyFile(sourceEntry.getText(), destinationEntry.getText());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };

        new Thread(task).start();
    }
}
