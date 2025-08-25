package com.automation.project.xunit_frameworks.testng;

import com.automation.project.xunit_frameworks.testng.listeners.TestListenerDemo;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Date;

import static java.lang.Thread.sleep;

@Listeners({TestListenerDemo.class})
public class ParallelExecutionTest {

    @Test(description = "First test in parallel run")
    public void testParallelOne() throws InterruptedException {
        checkTime();
        sleep(5000);

    }

    @Test(description = "Second test in parallel run")
    public void testParallelTwo() {
        checkTime();
    }

    private void checkTime() {
        System.out.println("Current time: " + new Date(System.currentTimeMillis()));
//        System.out.println(Thread.currentThread().getId());
    }
}
