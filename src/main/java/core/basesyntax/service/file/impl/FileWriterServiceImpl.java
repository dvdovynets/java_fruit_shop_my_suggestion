package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.FileWriterService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String FILE_EXCEPTION_MESSAGE = "Can't write to file!";

    @Override
    public void write(String fileName, String text) {
        try {
            Files.writeString(Path.of(fileName), text);
        } catch (IOException e) {
            throw new RuntimeException(FILE_EXCEPTION_MESSAGE
                    + ", " + fileName, e);
        }
    }
}
