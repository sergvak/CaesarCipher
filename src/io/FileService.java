package io;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
public class FileService {
    public FileService() {
    }
    public boolean isFileExit(Path filePath) {
        return Files.exists(filePath, new LinkOption[0]);
    }
    public String read(Path filePath) throws IOException {
        return new String(Files.readAllBytes(filePath));
    }
    public void write(Path path, String text) throws IOException {
        Files.writeString(path, text);
    }
    public Path addFileNameAnnotation(Path filePath, String annotation) {
        StringBuilder fileName = new StringBuilder(filePath.getFileName().toString());
        Path dir = filePath.getParent();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            fileName.insert(fileName.lastIndexOf("."), annotation);
            return dir.resolve(Path.of(fileName.toString()));
        } else {
            return null;
        }
    }
}