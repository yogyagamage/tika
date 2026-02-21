package org.apache.tika.io;

import org.apache.tika.io.TikaInputStream;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TikaInputStreamskip_IOUtilsskipFikaTest {

    @Test
    public void testSkip() throws IOException {
        byte[] data = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 };
        ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
        
        try (TikaInputStream tikaStream = TikaInputStream.get(byteStream)) {
            tikaStream.skip(3L);
        }
    }
}
