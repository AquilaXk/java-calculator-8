package calculator;

import calculator.parser.InputHandler;
import calculator.validation.Validator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;

public class Application {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요.");

        String firstLine = Console.readLine();
        String finalInput;

        if (firstLine == null) {
            firstLine = "";
        }


        if (firstLine.startsWith(CUSTOM_DELIMITER_PREFIX)) {

            String secondLine = Console.readLine();



            finalInput = firstLine + "\n" + secondLine;
        } else {

            finalInput = firstLine;
        }

        InputHandler inputHandler = new InputHandler(finalInput);
        String[] tokens = inputHandler.parseTokens();
        List<BigDecimal> numbers = Validator.validateAndConvert(tokens);
        BigDecimal result = Calculator.calculate(numbers);
        System.out.println("결과값 : " + result);
    }
}

