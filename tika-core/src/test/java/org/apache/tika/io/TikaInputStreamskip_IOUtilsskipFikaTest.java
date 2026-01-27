package org.apache.tika.io;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class TikaInputStreamskip_IOUtilsskipFikaTest {

    @Test
    void testSkip() throws IOException {
        byte[] data = new byte[]{1, 2, 3, 4, 5};
        InputStream inputStream = new ByteArrayInputStream(data);
        TikaInputStream tikaInputStream = TikaInputStream.get(inputStream);
        
        tikaInputStream.skip(2L);
    }
}
