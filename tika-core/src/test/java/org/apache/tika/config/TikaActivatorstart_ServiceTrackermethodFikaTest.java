package org.apache.tika.config;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.osgi.framework.BundleContext;

public class TikaActivatorstart_ServiceTrackermethodFikaTest {

    @Test
    public void testStartMethodInvokesServiceTrackerConstructor() throws Exception {
        BundleContext mockBundleContext = Mockito.mock(BundleContext.class);
        
        TikaActivator activator = new TikaActivator();
        activator.start(mockBundleContext);
    }
}
