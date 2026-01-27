package org.apache.tika.embedder;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.parser.ParseContext;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExternalEmbedderembed_BuildergetFikaTest {

    @Test
    public void testEmbedInvokesBuilderGet() throws IOException, TikaException {
        // Create instance using default constructor
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to avoid file tokens and ensure execution path
        // that will invoke UnsynchronizedByteArrayOutputStream.builder().get()
        embedder.setCommand("echo", "test");
        
        // Set metadata command arguments to ensure hasMetadataCommandArguments = true
        Map<Property, String[]> metadataArgs = new HashMap<>();
        metadataArgs.put(Property.externalClosedChoise("test", "value"), new String[]{"--test"});
        embedder.setMetadataCommandArguments(metadataArgs);
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
