package com.automation.project.xunit_frameworks.testng;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");
        List<String> files = new ArrayList<>();
        files.addAll(new ArrayList<String>() {{
            add("testng2.xml");
        }});
        suite.setSuiteFiles(files);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);
        tng.run();
    }
}


