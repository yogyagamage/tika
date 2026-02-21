package org.apache.tika.io;

import org.apache.tika.io.TikaInputStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

class TikaInputStreamskip_IOUtilsskipFikaTest {

    @Test
    void testSkip() throws IOException {
        byte[] data = new byte[100];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        TikaInputStream tikaInputStream = TikaInputStream.get(byteArrayInputStream);
        
        tikaInputStream.skip(10);
    }
}
