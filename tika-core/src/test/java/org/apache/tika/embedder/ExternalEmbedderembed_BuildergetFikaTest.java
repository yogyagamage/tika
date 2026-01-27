package org.apache.tika.embedder;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExternalEmbedderembed_BuildergetFikaTest {

    @Test
    public void testEmbedPathToBuilderGet() throws IOException, TikaException {
        // Create instance using default constructor
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure to ensure the path executes through the target method
        // Set command to avoid file tokens so we go through stdErr path
        embedder.setCommand("echo", "test");
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        // This should trigger the call to UnsynchronizedByteArrayOutputStream.builder().get()
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
