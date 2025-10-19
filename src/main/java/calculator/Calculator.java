package calculator;

import java.util.List;
import java.math.BigDecimal;


public class Calculator {


    public static BigDecimal calculate(List<BigDecimal> numbers) {
        BigDecimal sum = BigDecimal.ZERO;

        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }

        return sum;
    }

}
