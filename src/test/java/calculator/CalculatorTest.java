package calculator;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void 덧셈기능() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(Calculator.calculate(numbers)).isEqualTo(55);
    }
    @Test
    void 빈_리스트_덧셈() {
        List<Integer> numbers = Arrays.asList(); // 빈 리스트
        assertThat(Calculator.calculate(numbers)).isEqualTo(0); // 0을 기대
    }

    @Test
    void 요소가_하나일때_덧셈() {
        List<Integer> numbers = Arrays.asList(7); // 요소 1개
        assertThat(Calculator.calculate(numbers)).isEqualTo(7); // 7을 기대
    }
}
