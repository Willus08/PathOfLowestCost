package posidenpalace.com.pathoflowestcost.PathCalculationTests;


import org.junit.Before;
import org.junit.Test;

import posidenpalace.com.pathoflowestcost.PathCalculation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathCalculationTests {

    private PathCalculation calculator;
    private int[][] testMatrix1_1;


    @Before
    public void setup(){
        calculator = new PathCalculation();
        testMatrix1_1 = new int[][]{{1}};

    }

    @Test
    public void Should_Pass_Thru_Simple_Matrix(){
        calculator.beginTest(testMatrix1_1);
        assertEquals(1, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        assertArrayEquals(new int[1], calculator.getSolution());

    }


}
