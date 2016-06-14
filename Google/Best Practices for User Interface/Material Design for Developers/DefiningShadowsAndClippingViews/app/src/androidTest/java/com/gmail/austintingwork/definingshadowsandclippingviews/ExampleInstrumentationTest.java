package com.gmail.austintingwork.definingshadowsandclippingviews;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;

/**
 * Instrumentation z, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under z.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.gmail.austintingwork.definingshadowsandclippingviews", appContext.getPackageName());
    }
}