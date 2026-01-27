package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.apache.tika.detect.Detector;
import org.apache.tika.parser.Parser;
import org.osgi.framework.ServiceReference;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TikaActivatorstart_ServiceTrackeropenFikaTest {

    @Test
    public void testStart() throws Exception {
        BundleContext mockBundleContext = mock(BundleContext.class);
        ServiceReference mockDetectorRef = mock(ServiceReference.class);
        ServiceReference mockParserRef = mock(ServiceReference.class);
        
        when(mockBundleContext.getServiceReference(Detector.class.getName()))
            .thenReturn(mockDetectorRef);
        when(mockBundleContext.getServiceReference(Parser.class.getName()))
            .thenReturn(mockParserRef);
        
        TikaActivator activator = new TikaActivator();
        activator.start(mockBundleContext);
    }
}
