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

public class ExternalEmbedderembed_UnsynchronizedByteArrayOutputStreamtoStringFikaTest {

    @Test
    public void test() throws IOException, TikaException {
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to trigger the path to toString(String)
        embedder.setCommand("false"); // Command that will fail with exit code != 0
        
        // Create required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point
        try {
            embedder.embed(metadata, inputStream, outputStream, parseContext);
        } catch (TikaException e) {
            // Expected - the command "false" will fail with exit code != 0
            // This triggers the stdErrOutputStream.toString(UTF_8.name()) call
        }
    }
}
