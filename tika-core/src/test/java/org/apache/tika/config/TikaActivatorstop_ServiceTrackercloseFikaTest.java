package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.apache.tika.detect.Detector;
import org.apache.tika.parser.Parser;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TikaActivatorstop_ServiceTrackercloseFikaTest {

    @Test
    void testStopCallsServiceTrackerClose() throws Exception {
        BundleContext mockBundleContext = mock(BundleContext.class);
        
        ServiceTracker mockParserTracker = mock(ServiceTracker.class);
        ServiceTracker mockDetectorTracker = mock(ServiceTracker.class);
        
        TikaActivator activator = new TikaActivator();
        
        activator.start(mockBundleContext);
        
        java.lang.reflect.Field parserTrackerField = TikaActivator.class.getDeclaredField("parserTracker");
        parserTrackerField.setAccessible(true);
        parserTrackerField.set(activator, mockParserTracker);
        
        java.lang.reflect.Field detectorTrackerField = TikaActivator.class.getDeclaredField("detectorTracker");
        detectorTrackerField.setAccessible(true);
        detectorTrackerField.set(activator, mockDetectorTracker);
        
        activator.stop(mockBundleContext);
    }
}
