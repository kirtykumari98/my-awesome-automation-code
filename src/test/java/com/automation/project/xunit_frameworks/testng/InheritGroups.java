package com.automation.project.xunit_frameworks.testng;

import org.testng.annotations.*;

@Test(groups = "acceptance")
public class InheritGroups {

    @BeforeSuite(inheritGroups = true)
    public void beforeSuite() {
        System.out.println("I am @BeforeSuite");
    }

    @BeforeTest(inheritGroups = true)
    public void beforeTest() {
        System.out.println("I am @BeforeTest");
    }

    /*@BeforeGroups
    public void beforeGroupsNoGroup() {
        System.out.println("I am @BeforeGroups");
    }*/

    @BeforeGroups(inheritGroups = true)
    public void beforeGroupsInherit() {
        System.out.println("I am @BeforeGroups(inheritGroups = true)");
    }

    /*@BeforeGroups(groups = {"acceptance","execute group1"})
    public void beforeGroupsGroups() {
        System.out.println("I am @BeforeGroups(groups = {\"acceptance\"}");
    }*/

    @BeforeClass(inheritGroups = true)
    public void beforeClass() {
        System.out.println("I am @BeforeClass");
    }

    @BeforeMethod(inheritGroups = true)
    public void beforeMethod() {
        System.out.println("I am @BeforeMethod");
    }

    @Test
    public void test() {
        System.out.println("I am @Test");
    }
}

