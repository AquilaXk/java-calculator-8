package Validation;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @Test
    void 정상_입력() {
        String[] tokens = {"1", "3", "5"};
        List<Integer> result = Validator.validateAndConvert(tokens);

        assertThat(result).containsExactly(1, 3, 5);
    }

    @Test
    void 음수_입력() {
        String[] tokens = {"3", "-7", "0"};

        assertThatThrownBy(
                () -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수를 입력했습니다.");
    }

    @Test
    void 문자_입력() {
        String[] tokens = {"World", "6", "Hello"};

        assertThatThrownBy(
                () -> Validator.validateAndConvert(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 값이 포함되어있습니다.");
    }
}
