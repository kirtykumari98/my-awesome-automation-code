package com.automation.project.xunit_frameworks.testng;

import org.testng.annotations.Test;

public class SuperTestNgClass {

    @Test
    public void superTestNgMethod() {
        System.out.println("Super testng method");
        System.out.println(Thread.currentThread().getId());
    }
}