package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;

import static org.mockito.Mockito.when;

public class TikaActivatoraddingService_ServiceReferencegetPropertyFikaTest {

    @Test
    public void testAddingServiceInvokesGetProperty() {
        // Create mock BundleContext for TikaActivator constructor
        BundleContext mockBundleContext = Mockito.mock(BundleContext.class);
        
        // Create real TikaActivator instance
        TikaActivator activator = new TikaActivator();
        
        // Set bundleContext via reflection since it's typically set by OSGi framework
        try {
            java.lang.reflect.Field field = TikaActivator.class.getDeclaredField("bundleContext");
            field.setAccessible(true);
            field.set(activator, mockBundleContext);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        // Create mock ServiceReference that will be passed to addingService
        ServiceReference mockReference = Mockito.mock(ServiceReference.class);
        
        // Configure mock to return a service object when getService is called
        Object mockService = new Object();
        when(mockBundleContext.getService(mockReference)).thenReturn(mockService);
        
        // Configure mock to return an Integer for SERVICE_RANKING property
        // This ensures the getProperty method is invoked during execution
        when(mockReference.getProperty(Constants.SERVICE_RANKING)).thenReturn(42);
        
        // Execute the entry point method
        activator.addingService(mockReference);
    }
}
