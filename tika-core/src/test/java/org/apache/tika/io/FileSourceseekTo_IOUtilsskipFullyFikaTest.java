package org.apache.tika.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.IOException;

public class FileSourceseekTo_IOUtilsskipFullyFikaTest {

    @Test
    public void testSeekToInvokesSkipFully(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, "test content for seeking".getBytes());
        
        FileSource fileSource = new FileSource(testFile);
        fileSource.seekTo(5L);
    }
}
