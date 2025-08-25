package com.automation.project.xunit_frameworks.testng.booktickets;

import com.automation.project.xunit_frameworks.testng.MathUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Test
public class MathUtilsTest {
    @Test(groups = "run test", dataProvider = "divideByZero")
    public void divide(Integer x, Integer y) {
        MathUtils mu = new MathUtils();
        System.out.println(x/y);
        assertEquals(mu.divide(x, y), x / y);
    }

/*    @DataProvider(name = "numbers")
    public Object[][] getData() {
        return new Object[][] { new Object[] { 4, 2 } };
    }*/

    @DataProvider(name = "divideByZero")
    public Object[][] getDataDivide() {
        return new Object[][] { new Object[] { 4, 2 } };
    }



}
