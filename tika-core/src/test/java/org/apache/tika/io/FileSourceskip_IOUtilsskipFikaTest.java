package org.apache.tika.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.IOUtils;

public class FileSourceskip_IOUtilsskipFikaTest {
    
    @Test
    public void testSkip() throws IOException {
        // Create a temporary file with some content
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, "test content for skipping".getBytes());
        
        // Instantiate FileSource using the constructor
        FileSource fileSource = new FileSource(tempFile);
        
        // Call the entry point method which should invoke IOUtils.skip
        fileSource.skip(5L);
        
        // Clean up
        fileSource.close();
        Files.deleteIfExists(tempFile);
    }
}
