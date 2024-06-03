package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String pathToCircleData = args[0];
        String pathToDotsData = args[1];

        List<Double> circleData = new ArrayList<>();


        // читаем данные окружности
        try {
            File file = new File(pathToCircleData);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                circleData.add(scanner.nextDouble());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }

        // читаем точки
        try {
            File file = new File(pathToDotsData);
            Scanner scanner = new Scanner(file);

            double x;
            double y;

            while (scanner.hasNextInt()) {
                x = scanner.nextDouble();
                y = scanner.nextDouble();
                Solver(x, y, circleData);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }

    }

    private static void Solver(double x, double y, List<Double> circleData) {
        // возможно лучше было писать используя корни, но я сделал так :)
        double value = Math.pow(x - circleData.get(0), 2) + Math.pow(y - circleData.get(1), 2) - Math.pow(circleData.get(2), 2);
        if (value == 0) {
            System.out.println(0);
        } else if (value < 0) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
