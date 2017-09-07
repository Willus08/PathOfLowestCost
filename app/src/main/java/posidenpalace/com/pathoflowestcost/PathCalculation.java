package posidenpalace.com.pathoflowestcost;


import java.util.Arrays;

public class PathCalculation {
    private int[][] testingMatrix;
    private boolean mazeComplete;
    private int cost;
    private int scale = 0;// used to scale the entries in the path as I am cutting the arrays down to a size of 3 for space
    private int[] solution;
    private int runningCost;
    private int lowestCost = 50;
    private int[] currentPath;
    private int depth = 0;
    private int colomnLength;
    private int rowLength;


    public void beginTest(int[][] matrix) {
        testingMatrix = matrix;
        runningCost = 0;
        colomnLength = testingMatrix[0].length;
        rowLength = testingMatrix.length;
        solution = new int[rowLength];
        currentPath = new int[rowLength];


        for (int i = 0; i < colomnLength; i++) {
            depth = 1;

            if (testingMatrix[0][i] < 50) {
                currentPath[depth - 1] = i+1;
                if (rowLength == 1) {
                    runningCost = testingMatrix[0][i];

                } else {
                    int[] adjacentEntries = createAdjacentArray(i);
                    runningCost += testingMatrix[0][i] + calculateLowestCost(adjacentEntries);
                    System.out.println("running cost: "+runningCost);
                }

                if (runningCost < lowestCost) {
                    System.out.println(Arrays.toString(currentPath));
                    lowestCost = runningCost;
                    runningCost = 0;
                    System.out.println(lowestCost);
                    setSolution(currentPath.clone());
                    setMazeComplete(true);
                } else {
                    runningCost = 0;
                }
            } else {
                lowestCost = 0;
            }

        }
        setCost(lowestCost);


    }

    private int calculateLowestCost(int[] column) {
        depth++;
        int smallestEntry;
        switch (column.length) {
            case 1:
                if (runningCost + column[0] >= 50) {
                    setMazeComplete(false);
                    lowestCost = runningCost;
                    return lowestCost;
                }
                if (depth >= rowLength) {
                    currentPath[depth - 1] = 1;
                    return column[0];

                } else {
                    int[] adjacentEntries0 = createAdjacentArray(0);
                    return column[0] + calculateLowestCost(adjacentEntries0);
                }

            case 2:
                smallestEntry = Math.min(column[1], column[0]);
                if (runningCost + smallestEntry >= 50) {
                    setMazeComplete(false);
                    lowestCost = runningCost;
                    return lowestCost;
                }
                if (depth >= rowLength) {
                    if (column[0] <= column[1]) {
                        return column[0];
                    }else
                        return column[1];
                } else {
                  if (column[0] <= column[1]){
                      currentPath[depth-1] = scale;
                      int[] adjacentEntries = createAdjacentArray(0);
                      return column[0] + calculateLowestCost(adjacentEntries);
                  }else {
                      currentPath[depth-1] = scale++;
                      int[] adjacentEntries = createAdjacentArray(1);
                      return column[1] + calculateLowestCost(adjacentEntries);
                  }
                }

            default:
                smallestEntry = Math.min(column[0], Math.min(column[1], column[2]));
                if (runningCost + smallestEntry >= 50) {
                    setMazeComplete(false);
                    lowestCost = runningCost;
                    return lowestCost;
                }
                if (depth >= rowLength) {
                    if (column[0] <= column[1] ){
                        if(column[0] <= column[2]) {
                            currentPath[depth-1] = scale--;
                           return column[0];
                        }else if (column[2]<= column[1]){
                            currentPath[depth-1] = scale++;
                            return column[2];

                        }
                    }else{
                        currentPath[depth-1] = scale;
                      return column[1];
                    }
                } else {
                   if (column[0] <= column[1] ){
                       if(column[0] <= column[2]) {
                           currentPath[depth-1] = scale--;
                           int[] adjacentEntries = createAdjacentArray(0);
                           return column[0] + calculateLowestCost(adjacentEntries);
                       }else if (column[2]<= column[1]){
                           currentPath[depth-1] = scale++;
                           int[] adjacentEntries = createAdjacentArray(1);
                           return column[2] + calculateLowestCost(adjacentEntries);
                       }
                   }else{
                       currentPath[depth-1] = scale;
                       int[] adjacentEntries = createAdjacentArray(1);
                       return column[1] + calculateLowestCost(adjacentEntries);
                   }
                }

        }
        return runningCost;
    }


    private int[] createAdjacentArray(int i) {
        int[] adjacentEntries;
        if (depth == 1) {
            scale = i;
        } else {
            switch (i) {
                case 0:
                    scale--;
                    break;
                case 2:
                    scale++;
                    break;

            }
            if (scale < 0) {
                scale = colomnLength-1;
            }
            if (scale >= colomnLength){
                scale=0;
            }
        }

        switch (colomnLength ){
            case 1:
                adjacentEntries = new int[1];
                adjacentEntries[0] = testingMatrix[depth][i];
                break;
            case 2:
                adjacentEntries = new int[2];
                adjacentEntries[0] = testingMatrix[depth][0];
                adjacentEntries[1] = testingMatrix[depth][1];
                break;
            case 3:
                adjacentEntries = new int[3];
                adjacentEntries[0] = testingMatrix[depth][0];
                adjacentEntries[1] = testingMatrix[depth][1];
                adjacentEntries[2] = testingMatrix[depth][2];
                break;
            default:
                adjacentEntries = new int[3];
                if (i-1 < 0){// tests to see if this is the top row so it can wrap to the bottom
                    adjacentEntries[0] = testingMatrix[depth][colomnLength -1];
                }else {
                    adjacentEntries[0] = testingMatrix[depth][i-1];
                }

                adjacentEntries[1] = testingMatrix[depth][i];

                if (i+1 >= colomnLength-1){// tests to see if this is the bottom row so it can wrap to the top
                    adjacentEntries[2] = testingMatrix[depth][0];
                }else {
                    adjacentEntries[2] = testingMatrix[depth][i+1];
                }

        }

        return adjacentEntries;
    }

    public boolean isMazeComplete() {
        return mazeComplete;
    }

    private void setMazeComplete(boolean mazeComplete) {
        this.mazeComplete = mazeComplete;
    }

    public int getCost() {
        return cost;
    }

    private void setCost(int cost) {
        this.cost = cost;
    }

    public int[] getSolution() {
        return solution;
    }

    private void setSolution(int[] solution) {
        this.solution = solution;
    }
}
