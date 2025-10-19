package calculator;


public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }

        return 1;
    }
}
