package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String FILE_EXCEPTION_MESSAGE = "File not found!";

    @Override
    public List<String> read(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(FILE_EXCEPTION_MESSAGE
                    + "\nFile, " + fileName, e);
        }
    }
}
