package com.automation.project.xunit_frameworks.testng;

import com.automation.project.xunit_frameworks.testng.listeners.TestListenerDemo;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Listeners(TestListenerDemo.class)
public class AssertionsTest {

    @Test(description = "test division for 3 by 2 equals 1.5")
    public void testDivision()
    {
        double result=3.0/2.0;

        assertEquals(result,1.5,"Incorrect result of division");
        assertNotEquals(result,1.0,"Incorrect result");
        assertTrue(result==1.5);
        assertFalse(result==1.0);

    }

    @Test(description = "test to test assert same method", enabled = false)
    public void testStrings() {
        String name = "Srikala";
        String personName = name;
        assertSame(name, personName, "different names");
        assertNotNull(personName);
        personName=null;
        assertNull(personName);
    }


}
