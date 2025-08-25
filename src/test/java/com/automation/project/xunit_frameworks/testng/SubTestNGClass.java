package com.automation.project.xunit_frameworks.testng;

import org.testng.annotations.Test;

public class SubTestNGClass extends SuperTestNgClass {

    @Test
    public void subTestNgMethod() {
        System.out.println("Sub testng method");
        System.out.println(Thread.currentThread().getId());
    }
}
