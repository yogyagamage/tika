package org.apache.tika.config;

import org.apache.tika.detect.Detector;
import org.apache.tika.parser.Parser;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TikaActivatorstart_ServiceTrackermethodFikaTest {

    @Test
    void testStartMethodTriggersServiceTrackerConstructor() throws Exception {
        BundleContext mockBundleContext = Mockito.mock(BundleContext.class);
        
        TikaActivator activator = new TikaActivator();
        activator.start(mockBundleContext);
    }
}
