package com.automation.project.xunit_frameworks.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreCollectionTest {

    @Before

    //ScoreCollection -setup
    @Test
    public void answersArithmeticMeanOfTwoNumbers() {
        ScoreCollection scoreCollection = new ScoreCollection();

        //inputs
        scoreCollection.add(() -> 5);
        scoreCollection.add(() -> 7);

        //storing the result
        int result = scoreCollection.arithmeticMean();

        //verify
        assertEquals(7, result);
    }

    @Test
    public void testWithNegativeValues()
    {
        ScoreCollection scoreCollection = new ScoreCollection();

        //inputs
        scoreCollection.add(() -> -45);
        scoreCollection.add(() -> 7);

        //storing the result
        int result = scoreCollection.arithmeticMean();

        //verify
//        assertNotEquals(6, result);
        assertNotEquals("The expected and actual values do not match!",-6,result);
    }


}