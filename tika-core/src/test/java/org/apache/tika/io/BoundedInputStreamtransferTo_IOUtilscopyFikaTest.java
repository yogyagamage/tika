package org.apache.tika.io;

import org.junit.jupiter.api.Test;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

class BoundedInputStreamtransferTo_IOUtilscopyFikaTest {

    @Test
    void testTransferToCallsIOUtilsCopy() throws Exception {
        byte[] data = new byte[] {1, 2, 3, 4, 5};
        InputStream underlyingStream = new ByteArrayInputStream(data);
        long max = 100L;
        
        BoundedInputStream boundedStream = new BoundedInputStream(max, underlyingStream);
        OutputStream outputStream = new ByteArrayOutputStream();
        
        boundedStream.transferTo(outputStream);
    }
}
