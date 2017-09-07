package posidenpalace.com.pathoflowestcost.PathCalculationTests;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import posidenpalace.com.pathoflowestcost.PathCalculation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PathCalculationTests {

    private PathCalculation calculator;
    private int[][] testMatrix_1x1;
    private int[][] testMatrix_6x1;


    @Before
    public void setup(){
        calculator = new PathCalculation();
        testMatrix_1x1 = new int[][]{{1}};
        testMatrix_6x1 = new int[][]{{1,2,3,4,5,-2}};
    }

    @Test
    public void Should_Pass_Thru_Simple_Matrix(){
        calculator.beginTest(testMatrix_1x1);
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(1, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        assertArrayEquals(new int[]{1}, calculator.getSolution());

    }

    @Test
    public void Should_choose_Lowest_Starting_Point(){
        calculator.beginTest(testMatrix_6x1);
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(-2, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        assertArrayEquals(new int[]{6}, calculator.getSolution());
    }


}
