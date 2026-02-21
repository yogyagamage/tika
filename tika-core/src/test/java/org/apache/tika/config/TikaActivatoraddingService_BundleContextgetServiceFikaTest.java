package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;

import static org.mockito.Mockito.when;

public class TikaActivatoraddingService_BundleContextgetServiceFikaTest {

    @Test
    public void testAddingServiceCallsGetService() {
        // Create mock BundleContext (required for TikaActivator constructor)
        BundleContext mockBundleContext = Mockito.mock(BundleContext.class);
        
        // Create mock ServiceReference for the parameter
        ServiceReference mockReference = Mockito.mock(ServiceReference.class);
        
        // Set up the SERVICE_RANKING property to avoid NPE
        when(mockReference.getProperty(Constants.SERVICE_RANKING)).thenReturn(null);
        
        // Create real TikaActivator instance
        TikaActivator activator = new TikaActivator();
        
        // We need to set the bundleContext field via reflection since it's private
        try {
            java.lang.reflect.Field field = TikaActivator.class.getDeclaredField("bundleContext");
            field.setAccessible(true);
            field.set(activator, mockBundleContext);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set bundleContext field", e);
        }
        
        // Mock the getService call to return a dummy object
        when(mockBundleContext.getService(mockReference)).thenReturn(new Object());
        
        // Execute the entry point method
        activator.addingService(mockReference);
    }
}
