package posidenpalace.com.pathoflowestcost;



public class PathCalculation {
    private int[][] testingMatrix;
    private boolean mazeComplete;
    private int cost;
    private int[] solution;

    PathCalculation(int[][] newMatrix){
        this.testingMatrix = newMatrix;
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
