package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void 빈_문자열_또는_null_입력_테스트() {
        assertThat(StringCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringCalculator.splitAndSum("")).isEqualTo(0);
        assertThat(StringCalculator.splitAndSum("    ")).isEqualTo(0);
    }
}
