package org.apache.tika.embedder;

import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.external.ExternalParser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExternalEmbedderembed_UnsynchronizedByteArrayOutputStreambuilderFikaTest {

    @Test
    public void testEmbed() throws IOException, TikaException {
        // Create instance using default constructor
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to avoid file tokens and ensure execution path reaches target method
        embedder.setCommand("echo", "test");
        
        // Set metadata command arguments to ensure hasMetadataCommandArguments is true
        Map<Property, String[]> metadataArgs = new HashMap<>();
        metadataArgs.put(Property.externalText("test"), new String[]{"value"});
        embedder.setMetadataCommandArguments(metadataArgs);
        
        // Set supported embed types (optional, but ensures no NPE)
        Set<MediaType> supportedTypes = new HashSet<>();
        supportedTypes.add(MediaType.TEXT_PLAIN);
        embedder.setSupportedEmbedTypes(supportedTypes);
        
        // Prepare input parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Call entry point - this should trigger the chain leading to 
        // UnsynchronizedByteArrayOutputStream.builder()
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
