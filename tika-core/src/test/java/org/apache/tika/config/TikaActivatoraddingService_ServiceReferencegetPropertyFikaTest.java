package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.apache.tika.detect.Detector;
import org.apache.tika.parser.Parser;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TikaActivatoraddingService_ServiceReferencegetPropertyFikaTest {

    @Test
    void testAddingServiceInvokesGetProperty() {
        // Create the activator instance
        TikaActivator activator = new TikaActivator();
        
        // Create mock BundleContext
        BundleContext mockBundleContext = mock(BundleContext.class);
        
        // Create mock ServiceReference that will be passed to addingService
        ServiceReference mockServiceReference = mock(ServiceReference.class);
        
        // Setup the mock to return a valid Integer when getProperty is called with SERVICE_RANKING
        when(mockServiceReference.getProperty(Constants.SERVICE_RANKING)).thenReturn(100);
        
        // Create mock service to be returned by bundleContext.getService
        Object mockService = new Object();
        when(mockBundleContext.getService(mockServiceReference)).thenReturn(mockService);
        
        // Create mock ServiceTrackers
        ServiceTracker mockDetectorTracker = mock(ServiceTracker.class);
        ServiceTracker mockParserTracker = mock(ServiceTracker.class);
        
        // Use reflection to set the private fields since we don't have setters
        try {
            java.lang.reflect.Field bundleContextField = TikaActivator.class.getDeclaredField("bundleContext");
            bundleContextField.setAccessible(true);
            bundleContextField.set(activator, mockBundleContext);
            
            java.lang.reflect.Field detectorTrackerField = TikaActivator.class.getDeclaredField("detectorTracker");
            detectorTrackerField.setAccessible(true);
            detectorTrackerField.set(activator, mockDetectorTracker);
            
            java.lang.reflect.Field parserTrackerField = TikaActivator.class.getDeclaredField("parserTracker");
            parserTrackerField.setAccessible(true);
            parserTrackerField.set(activator, mockParserTracker);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set fields via reflection", e);
        }
        
        // Call the entry point method - this should invoke reference.getProperty(Constants.SERVICE_RANKING)
        activator.addingService(mockServiceReference);
    }
}
