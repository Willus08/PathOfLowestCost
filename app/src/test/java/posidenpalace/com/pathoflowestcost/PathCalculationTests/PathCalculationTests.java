package posidenpalace.com.pathoflowestcost.PathCalculationTests;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import posidenpalace.com.pathoflowestcost.PathCalculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathCalculationTests {

    private PathCalculation calculator;
    private int[][] testMatrix_1x1;
    private int[][] testMatrix_6x1;
    private int[][] testFailMatrix;
    private int[][] testMatrix_2x2;
    private int[][] testMatrix_5x5;
    private int[][] testMatrix_6x5;
    private int[][] testMatrix_1x5;

    @Before
    public void setup(){
        calculator = new PathCalculation();
        testMatrix_1x1 = new int[][]{{1}};
        testMatrix_6x1 = new int[][]{{1,2,3,4,5,-2}};
        testFailMatrix = new int[][] {{50}};
        testMatrix_2x2 = new int[][]{{1,2},{1,2}};
        testMatrix_5x5 = new int[][] {{1,2,3,4,5},{5,4,3,2,1},{1,2,5,4,3},{4,3,2,1,5},{1,3,5,4,2}};
        testMatrix_6x5 = new  int[][]{{3, 4, 1, 2, 8, 6,},{ 6 ,1, 8, 2, 7, 4,},{5, 9, 3, 9, 9, 5},{ 8, 4, 1, 3, 2, 6},{3, 7, 2, 1, 2, 3}};
        testMatrix_1x5 = new int[][] {{1},{1},{1},{1},{1}};


    }

    @Test
    public void Should_Pass_Thru_Simple_Matrix(){
        calculator.beginTest(testMatrix_1x1);
        System.out.println("*******************************************");
        System.out.println("test 1");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(1, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
       // assertArrayEquals(new int[]{1}, calculator.getSolution());
        System.out.println("*******************************************\n");

    }

    @Test
    public void Should_choose_Lowest_Starting_Point(){
        calculator.beginTest(testMatrix_6x1);
        System.out.println("*******************************************");
        System.out.println("test 2");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(-2, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{6}, calculator.getSolution());
        System.out.println("*******************************************\n");
    }

    @Test
    public void Should_fail_to_find_Path(){
        calculator.beginTest(testFailMatrix);
        System.out.println("*******************************************");
        System.out.println("test 3");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(0, calculator.getCost());
        assertFalse(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{0}, calculator.getSolution());
        System.out.println("*******************************************\n");
    }

    @Test
    public void Should_pass_a_2x2_Matrix(){
        calculator.beginTest(testMatrix_2x2);
        System.out.println("*******************************************");
        System.out.println("test 4");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(2, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{1,2}, calculator.getSolution());
        System.out.println("*******************************************\n");
    }

    @Test
    public void Test_pass_thru_a_5x5_Matrix(){
        calculator.beginTest(testMatrix_5x5);
        System.out.println("*******************************************");
        System.out.println("test 5");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(7, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{1, 2, 1, 5, 4, 5}, calculator.getSolution());
        System.out.println("*******************************************\n");

    }

    @Test
    public void Test_row(){
        calculator.beginTest(testMatrix_1x5);
        System.out.println("*******************************************");
        System.out.println("test 6");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(5, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{1, 1, 1, 1, 1}, calculator.getSolution());
        System.out.println("*******************************************\n");

    }

    @Test
    public void Test_Wrapping(){
        calculator.beginTest(testMatrix_6x5);
        System.out.println("*******************************************");
        System.out.println("test 7");
        System.out.println(calculator.isMazeComplete());
        System.out.println(calculator.getCost());
        System.out.println(Arrays.toString(calculator.getSolution()));
        assertEquals(11, calculator.getCost());
        assertTrue(calculator.isMazeComplete());
        //assertArrayEquals(new int[]{1, 2, 1, 5, 4, 5}, calculator.getSolution());
        System.out.println("*******************************************\n");

    }


}
