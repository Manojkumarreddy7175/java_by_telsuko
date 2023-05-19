public class pascal_memorisation
import java.util.HashMap;
        import java.util.Map;

public class PascalTriangle {
    private static Map<String, Integer> memo = new HashMap<>();

    public static int calculateCoefficient(int row, int column) {
        if (column == 0 || column == row) {
            return 1;
        }

        String key = row + "-" + column;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int coefficient = calculateCoefficient(row - 1, column - 1) + calculateCoefficient(row - 1, column);
        memo.put(key, coefficient);

        return coefficient;
    }

    public static void printPascalTriangle(int numRows) {
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column <= row; column++) {
                int coefficient = calculateCoefficient(row, column);
                System.out.print(coefficient + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
        printPascalTriangle(numRows);
    }
}

}
