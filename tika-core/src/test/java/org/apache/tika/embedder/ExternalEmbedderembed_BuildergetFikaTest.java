package org.apache.tika.embedder;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class ExternalEmbedderembed_BuildergetFikaTest {

    @Test
    public void testEmbed() throws Exception {
        // Create the ExternalEmbedder instance
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure minimal command that will trigger the target path
        // We need a command that will execute but not fail
        String[] command = {"echo", "test"};
        embedder.setCommand(command);
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        // This should trigger the chain ending with UnsynchronizedByteArrayOutputStream.Builder.get()
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
