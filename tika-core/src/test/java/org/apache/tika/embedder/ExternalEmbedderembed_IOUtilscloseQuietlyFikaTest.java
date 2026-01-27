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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExternalEmbedderembed_IOUtilscloseQuietlyFikaTest {

    @Test
    public void test() throws IOException, TikaException {
        ExternalEmbedder embedder = new ExternalEmbedder();
        
        // Configure command to use INPUT_FILE_TOKEN so that inputToStdIn becomes false
        // This will trigger the IOUtils.closeQuietly(tikaInputStream) call
        embedder.setCommand("cat", ExternalParser.INPUT_FILE_TOKEN);
        
        // Create minimal required parameters
        Metadata metadata = new Metadata();
        InputStream inputStream = new ByteArrayInputStream("test content".getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        ParseContext parseContext = new ParseContext();
        
        // Execute the entry point method
        embedder.embed(metadata, inputStream, outputStream, parseContext);
    }
}
