package calculator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 덧셈기능() {

        List<BigDecimal> numbers = Arrays.asList(
                new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"),
                new BigDecimal("4"), new BigDecimal("5"), new BigDecimal("6"),
                new BigDecimal("7"), new BigDecimal("8"), new BigDecimal("9"),
                new BigDecimal("10")
        );

        assertThat(Calculator.calculate(numbers)).isEqualTo(new BigDecimal("55"));
    }

    @Test
    void 빈_리스트_덧셈() {
        List<BigDecimal> numbers = Collections.emptyList();

        assertThat(Calculator.calculate(numbers)).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void 요소가_하나일때_덧셈() {
        List<BigDecimal> numbers = Arrays.asList(new BigDecimal("7"));

        assertThat(Calculator.calculate(numbers)).isEqualTo(new BigDecimal("7"));
    }
}

