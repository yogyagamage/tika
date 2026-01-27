package org.apache.tika.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileSourceskip_IOUtilsskipFikaTest {

    @Test
    public void testSkip() throws IOException {
        // Create a temporary file with content
        Path tempFile = Files.createTempFile("test", ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Test content for skipping");
        }
        
        // Instantiate FileSource using the constructor
        FileSource fileSource = new FileSource(tempFile);
        
        // Call the entry point method which should invoke IOUtils.skip
        fileSource.skip(5L);
        
        // Cleanup
        fileSource.close();
        Files.deleteIfExists(tempFile);
    }
}
