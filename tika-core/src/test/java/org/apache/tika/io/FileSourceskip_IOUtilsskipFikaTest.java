package org.apache.tika.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import org.apache.commons.io.IOUtils;

public class FileSourceskip_IOUtilsskipFikaTest {

    @TempDir
    private Path tempDir;

    @Test
    public void testSkip() throws Exception {
        Path testFile = tempDir.resolve("test.txt");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(testFile)))) {
            writer.write("This is test content for skip method.");
        }
        
        FileSource fileSource = new FileSource(testFile);
        fileSource.skip(5L);
        fileSource.close();
    }
}
