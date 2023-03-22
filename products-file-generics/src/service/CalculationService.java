package service;

import java.util.List;

public class CalculationService {

    private CalculationService() {
        throw new IllegalStateException("Utility class");
    }

    public static <T extends Comparable<T>> T max(List<T> list) {

        if (list.isEmpty()) {
            throw new IllegalStateException("List can't be empty");
        }
        T max = list.get(0);

        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }
}