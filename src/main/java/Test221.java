import controller.AppController;
import model.FileModel;
import view.FrameBuilder;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test221 {
    public static void main(String[] args) {
        Path filePath = Paths.get("test.txt");

        FileModel fileModel = FileModel.getInstance(filePath);
        fileModel.init();

        if (fileModel.getErrorMessage() != null) {
            System.err.println(fileModel.getErrorMessage());
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> new FrameBuilder(new AppController(fileModel)).build());

    }
}
