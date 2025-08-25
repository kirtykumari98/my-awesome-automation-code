package com.automation.project.xunit_frameworks.testng.factory;

import org.testng.annotations.Factory;

public class FactoryTest {

    @Factory
    public Object[]factoryMethod() {
        return new Object[]{
                new TestNgExample("Factory"),
                new TestNgExample("Method"),
                new TestNgExample("example"),
                new TestOne()
        };
    }
}
