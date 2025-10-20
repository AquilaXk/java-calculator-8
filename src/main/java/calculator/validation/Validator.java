package calculator.validation;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

public class Validator {
    public static List<BigDecimal> validateAndConvert(String[] tokens) {
        List<BigDecimal> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(validateToken(token));
        }
        return numbers;
    }

    private static BigDecimal validateToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력했습니다.");
        }

        BigDecimal num;
        try {
            num = new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어있습니다.");
        }

        if (num.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("0 또는 음수를 입력했습니다.");
        }

        return num;
    }
}
