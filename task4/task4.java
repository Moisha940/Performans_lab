package task4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  1) Можно за O^2. в тупую смотреть, какое у нас будет изменение для конкретно взятого элемента.
 *  2) Можно за NlogN сортировкой
 *  3) Я решил попытаться сделать за то, что в среднем работает за N. Медиана ищется с помощью базового quickSelect алгоритма
 *
 */

public class task4 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }

        int median = solver(nums, 0, nums.size() - 1, (nums.size() + 1) / 2);
        System.out.println(ans(nums, median));
    }

    static int solver(List<Integer> nums, int start, int end, int k) {
        int pivotPosition = pivotPositionSolver(nums, start, end);

        if (pivotPosition < k - 1) {
            return solver(nums, pivotPosition + 1, end, k);
        } else if (pivotPosition == k - 1) {
            return nums.get(pivotPosition);
        } else {
            return solver(nums, start, pivotPosition - 1, k);
        }
    }

    public static int pivotPositionSolver(List<Integer> nums, int left, int right) {
        int pivot = nums.get(right);
        int pivotPosition = left;

        for (int i = left; i <= right; i++) {
            if (nums.get(i) < pivot) {
                int temp = nums.get(i);
                nums.set(i, nums.get(pivotPosition));
                nums.set(pivotPosition, temp);
                ++pivotPosition;
            }
        }

        int temp = nums.get(right);
        nums.set(right, nums.get(pivotPosition));
        nums.set(pivotPosition, temp);
        return pivotPosition;
    }

    private static int ans(List<Integer> list, Integer median) {
        int ans = 0;
        for (Integer value : list) {
            ans += Math.abs(value - median);
        }
        return ans;
    }
}
