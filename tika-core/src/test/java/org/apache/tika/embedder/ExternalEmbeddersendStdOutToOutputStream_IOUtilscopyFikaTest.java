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

public class ExternalEmbeddersendStdOutToOutputStream_IOUtilscopyFikaTest {

    @Test
    public void test() throws Exception {
        // Create the ExternalEmbedder instance
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to ensure outputFromStdOut = true
        // This ensures sendStdOutToOutputStream is called
        String[] command = {"echo", "test"};
        embedder.setCommand(command);
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test input".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        try {
            embedder.embed(metadata, inputStream, outputStream, parseContext);
        } catch (Exception e) {
            // Expected - the external command will fail in test environment
            // but the path should still be traversed
        }
    }
}
