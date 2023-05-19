import java.util.HashMap;
import java.util.Map;

public class PascalTriangle {

    private static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int rows = 6; // Number of rows in Pascal's triangle

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                int coefficient = getPascalCoefficient(i, j);
                System.out.print(coefficient + " ");
            }
            System.out.println();
        }
    }

    private static int getPascalCoefficient(int row, int col) {
        if (col == 0 || col == row) {
            return 1; // Base case: first and last element in a row are always 1
        }

        String key = row + "_" + col;
        if (memo.containsKey(key)) {
            return memo.get(key); // Return memoized result if available
        }

        int coefficient = getPascalCoefficient(row - 1, col - 1) + getPascalCoefficient(row - 1, col);
        memo.put(key, coefficient); // Memoize the result

        return coefficient;
    }
}
