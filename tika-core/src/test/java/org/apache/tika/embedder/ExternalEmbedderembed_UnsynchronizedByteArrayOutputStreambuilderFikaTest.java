package org.apache.tika.embedder;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.Property;
import org.apache.tika.parser.ParseContext;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ExternalEmbedderembed_UnsynchronizedByteArrayOutputStreambuilderFikaTest {

    @Test
    public void testEmbed() throws Exception {
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        Map<Property, String[]> metadataArgs = new HashMap<>();
        metadataArgs.put(Property.externalText("test"), new String[]{"value"});
        embedder.setMetadataCommandArguments(metadataArgs);
        
        embedder.setCommand("echo", "test");
        
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
