package me.arun;

import me.arun.exception.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readDirectory(String directoryName) {
        try {
            return Files.walk(Paths.get(directoryName)).
                    filter(path -> path.toFile().isFile() && path.toFile().getName().endsWith(".sql")).
                    map((path) -> readFileContent(path)).
                    filter(content -> !content.trim().isEmpty()).
                    collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileException(e);
        }
    }

    private String readFileContent(Path path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path.toFile().getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
