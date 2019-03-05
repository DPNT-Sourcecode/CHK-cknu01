package befaster.solutions.SUM;

public class SumSolution {

    public int compute(int x, int y) {

        // check for x < 0 && x > 100
        if (x < 0  || x > 100) {
            throw new IllegalArgumentException("Invalid");
        }

        if (y < 0 || y > 100){
            throw new IllegalArgumentException("Invalid");
        }

        return x + y;
    }

}
