package controller;

import model.FileModel;

public class AppController {
    private FileModel fileModel;

    public AppController(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public String confirm(String line) {
        return fileModel.printLine(line);
    }

    public void exit() {
        fileModel.shutDown();
        System.exit(0);
    }
}
