package org.apache.tika.io;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class TikaInputStreamskip_IOUtilsskipFikaTest {

    @Test
    void testSkip() throws Exception {
        // Create a simple InputStream to wrap
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        InputStream inputStream = new ByteArrayInputStream(data);
        
        // Use the static factory method to create TikaInputStream
        TikaInputStream tis = TikaInputStream.get(inputStream);
        
        // Call the entry point method which should trigger IOUtils.skip
        tis.skip(2L);
    }
}
