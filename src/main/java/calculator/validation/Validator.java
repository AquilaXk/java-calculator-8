package calculator.validation;

import java.util.List;
import java.util.ArrayList;

public class Validator {
    public static List<Integer> validateAndConvert(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(validateToken(token));
        }
        return numbers;
    }

    private static int validateToken(String token) {
        if (token.trim().isEmpty() || token == null) {
            throw new IllegalArgumentException("빈 문자열을 입력했습니다.");
        }

        int num;
        try {
            num = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어있습니다.");
        }

        if (num < 0) {
            throw new IllegalArgumentException("음수를 입력했습니다.");
        }

        return num;
    }
}
