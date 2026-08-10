package org.apache.tika.embedder;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.external.ExternalParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
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
    public void testEmbedPathToBuilderGet() throws IOException, TikaException {
        // Create instance using default constructor
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to avoid file tokens and ensure execution path
        embedder.setCommand("echo", "test");
        
        // Set metadata command arguments to trigger metadata processing
        Map<Property, String[]> metadataArgs = new HashMap<>();
        metadataArgs.put(Property.externalText("test"), new String[]{"arg1"});
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
