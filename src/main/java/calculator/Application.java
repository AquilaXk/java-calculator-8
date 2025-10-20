package calculator;


import calculator.parser.InputHandler;
import calculator.validation.Validator;


import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        System.out.println("문자열을 입력하세요.");

        String input = Console.readLine();
        Console.close();

        InputHandler inputHandler = new InputHandler(input);
        String[] tokens = inputHandler.parseTokens();
        List<BigDecimal> numbers = Validator.validateAndConvert(tokens);
        BigDecimal result = Calculator.calculate(numbers);
        System.out.println("결과 : " + result);
    }
}