package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.apache.tika.detect.Detector;
import org.apache.tika.parser.Parser;
import org.osgi.util.tracker.ServiceTracker;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TikaActivatoraddingService_BundleContextgetServiceFikaTest {

    @Test
    public void testAddingServiceInvokesBundleContextGetService() throws Exception {
        TikaActivator activator = new TikaActivator();
        
        BundleContext mockBundleContext = mock(BundleContext.class);
        ServiceReference mockServiceReference = mock(ServiceReference.class);
        
        when(mockServiceReference.getProperty(Constants.SERVICE_RANKING))
            .thenReturn(Integer.valueOf(0));
        
        activator.start(mockBundleContext);
        
        activator.addingService(mockServiceReference);
    }
}
