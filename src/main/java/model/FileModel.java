package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileModel {
    private static FileModel fileModel;
    private Path filePath;
    private ArrayList<String> fileContents = new ArrayList<>();
    private BufferedWriter writer;
    private String errorMessage;
    private static final String lineExists = "Line already exists";

    private FileModel(Path filePath) {
        this.filePath = filePath;
    }

    public static FileModel getInstance(Path filePath) {
        if (fileModel == null) fileModel = new FileModel(filePath);
        return fileModel;
    }

    public boolean validatePath() throws IOException {
        if (!Files.exists(filePath) || Files.isDirectory(filePath)) Files.createFile(filePath);
        return true;
    }

    public void init() {
        try {
            validatePath();
            Files.lines(filePath, StandardCharsets.UTF_8).forEach(o -> fileContents.add(o.toLowerCase()));
            writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (IOException e) {
            errorMessage = e.getMessage();
        }
    }

    public void shutDown() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printLine(String line) {
        if (containsLine(line)) return lineExists;

        try {
            writer.write(line);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            return e.getMessage();
        }

        fileContents.add(line);
        return line;
    }

    public boolean containsLine(String line) {
        return fileContents.contains(line.toLowerCase());
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
