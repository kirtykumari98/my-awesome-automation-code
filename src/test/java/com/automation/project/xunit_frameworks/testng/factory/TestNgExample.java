package com.automation.project.xunit_frameworks.testng.factory;

import org.testng.annotations.Test;

public class TestNgExample {
    private String name;


    public TestNgExample(String name) {
        this.name = name;
    }

    @Test
    public void testParameterFromArgument() {
        System.out.println("name: " + name);
    }

}

