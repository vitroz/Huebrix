import java.util.Arrays;
import java.util.function.Consumer;

public class MatrixPrinter {

    public static void main(String[] args) {
        final int[][] matrix = new int[3][3];

        Consumer<int[]> noDelimiter = (row) -> {
            Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
            System.out.println();
        };

        Consumer<int[]> pipeDelimiter = (row) -> {
            Arrays.stream(row).forEach((el) -> System.out.print("| " + el + " "));
            System.out.println("|");
        };

        Consumer<int[]> likeAList = (row) -> {
            System.out.print("[");
            Arrays.stream(row)
            .forEach((el) -> System.out.print(" " + el + " "));
            System.out.println("]");
        };

        printMatrix(matrix, noDelimiter);
        System.out.println();
        printMatrix(matrix, pipeDelimiter);
        System.out.println();
        printMatrix(matrix, likeAList);

    }

    public static void printMatrix(int[][] matrix, Consumer<int[]> rowPrinter) {
        Arrays.stream(matrix)
        .forEach((row) -> rowPrinter.accept(row));
    }

}