package calculator;

import calculator.parser.InputHandler;
import calculator.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요.");
        InputHandler inputHandler = new InputHandler();
        String[] tokens = inputHandler.parseTokens();
        List<Integer> numbers = Validator.validateAndConvert(tokens);
        int answer = Calculator.calculate(numbers);
        System.out.println("결과값 : " + answer);
    }
}

