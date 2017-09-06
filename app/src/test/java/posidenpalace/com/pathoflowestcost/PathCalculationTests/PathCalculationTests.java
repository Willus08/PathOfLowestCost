package posidenpalace.com.pathoflowestcost.PathCalculationTests;


import org.junit.Before;
import org.junit.Test;

import posidenpalace.com.pathoflowestcost.PathCalculation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class PathCalculationTests {

    private PathCalculation mockedCalculator;
    int[][] testMatrix1_6;
    @Before
    public void setup(){
        mockedCalculator = mock(PathCalculation.class);
        testMatrix1_6 = new int[][]{{1,2,3,4,5,3}};
    }

    @Test
    public void Should_Pass_Thru_Simple_Matrix(){
        assertEquals(13, mockedCalculator.getCost());
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 3}, mockedCalculator.getSolution());
        assertTrue(mockedCalculator.isMazeComplete());
    }
}
