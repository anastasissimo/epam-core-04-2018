package com.epam.homework;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Task9 {

    /**
     * С консоли вводятся три целых числа A, B, C.
     * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
     * Необходимо найти корни этого уравнения.
     *
     * Формат входных данных:
     * Строка, содержащая 3 целых числа, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате решения уравнения может быть получено три варианта ответа:
     *
     * NO ROOTS
     * корень уравнения
     * первый корень уравнения, второй корень уравнения
     *
     * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
     * Значения корней округляются до 2 знаков после запятой.
     * В качестве десятичного разделителя используется точка.
     *
     * ---------------------------------------------------------------------------------------------------
     * Примеры выполнения задания:
     *
     * Входные данные:
     * 2 7 0
     *
     * Выходные данные:
     * -3.5, 0
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 4 4 1
     *
     * Выходные данные:
     * -0.5
     *
     *
     * ---------------------------------------------------------------------------------------------------
     * Входные данные:
     * 7 0 35
     *
     * Выходные данные:
     * NO ROOTS
     */
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.0");
        try (Scanner reader = new Scanner(System.in)) {
            double a = reader.nextDouble();
            double b = reader.nextDouble();
            double c = reader.nextDouble();
            List<Double> roots = getRoots(a, b, c);
            if (roots.size() == 0)
                System.out.println("NO ROOTS");
            else {
                System.out.println(roots.stream().map(item -> formatter.format(item)).collect(Collectors.joining(" ")));
            }
        }
    }

    private static List<Double> getRoots(double a, double b, double c) {
        double discriminant = getDiscriminant(a, b, c);
        if (discriminant > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            return Arrays.asList(x1, x2);
        }
        else if (discriminant == 0) {
            double x;
            x = -b / (2 * a);
            return Arrays.asList(x);
        }
        return new ArrayList<>();
    }

    private static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
}
