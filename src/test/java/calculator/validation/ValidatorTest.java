package calculator.validation;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.math.BigDecimal;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidatorTest {

    @Test
    void 정상() {
        String[] tokens = {"1", "3", "5.5"};
        List<BigDecimal> result = Validator.validateAndConvert(tokens);

        assertThat(result).containsExactly(
                new BigDecimal("1"),
                new BigDecimal("3"),
                new BigDecimal("5.5")
        );
    }

    @Test
    void 빈_배열() {
        String[] tokens = {};
        List<BigDecimal> result = Validator.validateAndConvert(tokens);

        assertThat(result).isEmpty();
    }

    @Test
    void 숫자_0_포함() {
        String[] tokens = {"0", "3", "0.0"};
        List<BigDecimal> result = Validator.validateAndConvert(tokens);

        assertThat(result).containsExactly(
                BigDecimal.ZERO,
                new BigDecimal("3"),
                new BigDecimal("0.0")
        );
    }


    @Test
    void 음수_포함() {
        String[] tokens = {"3", "-7", "0"};

        assertThatThrownBy(() -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수를 입력했습니다.");
    }

    @Test
    void 공백_문자열_포함() {
        String[] tokens = {"1", " ", "3"}; // " " (공백)

        assertThatThrownBy(() -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Test
    void 빈_문자열_포함() {
        String[] tokens = {"1", "", "3"};

        assertThatThrownBy(() -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Test
    void null_포함() {
        String[] tokens = {"1", null, "3"};

        assertThatThrownBy(() -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Test
    void 문자_포함() {
        String[] tokens = {"World", "6", "Hello"};

        assertThatThrownBy(() -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 값이 포함되어있습니다.");
    }
}