package calculator;

import java.util.List;


public class Calculator {


    public static int calculate(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

}
