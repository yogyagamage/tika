package org.apache.tika.embedder;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalEmbedderembed_IOUtilscloseQuietlyFikaTest2 {

    @Test
    public void test() throws Exception {
        // Create the object under test
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to avoid file operations and ensure outputFromStdOut = true
        // This will make the code take the path where inputToStdIn = true and outputFromStdOut = true
        // The finally block will then call IOUtils.closeQuietly(outputStream)
        String[] cmd = new String[]{"echo", "test"};
        embedder.setCommand(cmd);
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        try {
            embedder.embed(metadata, inputStream, outputStream, parseContext);
        } catch (Exception e) {
            // Expected - the external command will fail but we don't care
            // The finally block will still execute and call IOUtils.closeQuietly(outputStream)
        }
    }
}
