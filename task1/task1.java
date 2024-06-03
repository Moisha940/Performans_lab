package task1;


import java.util.ArrayList;
import java.util.List;

public class task1 {

    // данный код это просто реализация алгоритма построения цепочки

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // будем наши числа хранить в листе. Ответ потом перегоним в стрингу
        List<Integer> list = new ArrayList<>();
        list.add(1);

        // начало построения цепочки
        int i = 1;
        do {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    // первая цифра в цепочке повторяется
                    i = list.getLast();
                } else {
                    ++i;
                }
                if (i == n + 1) {
                    // если вышли за максимум, значит надо начать с начала
                    i = 1;
                }
            }
            list.add(i);
            --i;

        } while (list.getFirst() != list.getLast());

        // перегоняем из листа в стрингбилдер
        StringBuilder ans = new StringBuilder();
        for (int x : list) {
            ans.append(x);
        }
        ans.deleteCharAt(ans.length() - 1);
        System.out.println(ans);
    }
}
