package com.epam.homework;

import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = readMatrix(scanner);
            int columnNumber = scanner.nextInt();
            if (columnNumber == 0) {
                printMartix(matrix);
            }
            else {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = i; j > 0 && matrix[j][columnNumber] < matrix[j - 1][columnNumber]; j--) {
                        change(matrix, j);
                    }
                }
                printMartix(matrix);
            }
        }
    }

    private static void change(int[][] matrix, int j) {
        int[] current = matrix[j];
        matrix[j] = matrix[j - 1];
        matrix[j - 1] = current;
    }

    private static void printMartix(int[][] matrix) {
        System.out.println(matrix.length);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int col = 0; col < dimension; ++col) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
