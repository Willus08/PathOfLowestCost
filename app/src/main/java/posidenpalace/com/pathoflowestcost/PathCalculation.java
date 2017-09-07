package posidenpalace.com.pathoflowestcost;


public class PathCalculation {
    private int[][] testingMatrix;
    private boolean mazeComplete;
    private int cost;
    private int[] solution;
    private int runningCost;
    private int lowestCost = 50;
    private int[] currentPath;
    private int depth =0;


    public void beginTest(int[][] matrix){
        testingMatrix = matrix;
        runningCost = 0;
        solution = new int[testingMatrix.length];
        currentPath = new int[testingMatrix.length];
        cost =(calculateLowestCost(testingMatrix[0]));
        setMazeComplete(cost < 50);

    }

    private int calculateLowestCost(int[] column){
        depth++;
        for (int i = 0; i < column.length; i++) {
            int entry = column[i];
            currentPath[depth-1] =i+1;
            if (depth == testingMatrix.length) {
                if (depth-1 == 0){// makes sure the first entry of a nx1 array dosen't instantly return
                    runningCost = entry;
                }else {
                    return runningCost+=entry;
                }
            }else {
                int[] adjacentEntries = createAdjacentArray(i);
                runningCost += entry + calculateLowestCost(adjacentEntries);
            }
            if (runningCost<lowestCost){
                lowestCost = runningCost;
                setSolution(currentPath);
            }

        }
        return lowestCost;
    }

    private int[] createAdjacentArray(int i) {
        int[] adjacentEntries = new int[3];
        if (i-1 <0){// tests to see if this is the top row so it can wrap to the bottom
            adjacentEntries[0] = testingMatrix[depth][testingMatrix[depth].length];
        }else {
            adjacentEntries[0] = testingMatrix[depth][i-1];
        }

        adjacentEntries[1] = testingMatrix[depth][i];

        if (i+1 >testingMatrix[depth].length){// tests to see if this is the bottom row so it can wrap to the top
            adjacentEntries[2] = testingMatrix[depth][0];
        }else {
            adjacentEntries[2] = testingMatrix[depth][i+1];
        }
        return adjacentEntries;
    }

    public boolean isMazeComplete() {
        return mazeComplete;
    }

    public void setMazeComplete(boolean mazeComplete) {
        this.mazeComplete = mazeComplete;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getSolution() {
        return solution;
    }

    public void setSolution(int[] solution) {
        this.solution = solution;
    }
}
