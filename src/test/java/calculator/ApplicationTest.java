package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 커스텀_구분자_확인() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과값 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_정규식() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).contains("결과값 : 6");
        });
    }

    @Test
    void 기본_구분자() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과값 : 6");
        });
    }

    @Test
    void 기본_구분자_혼용() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과값 : 10");
        });
    }

    @Test
    void 숫자_0_1개() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과값 : 0");
        });
    }

    @Test
    void 숫자_1개() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과값 : 5");
        });
    }


    @Test
    void 음수_포함() {
        assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수를 입력했습니다.");
    }

    @Test
    void 문자_포함() {
        assertThatThrownBy(() -> runException("1,a,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 값이 포함되어있습니다.");
    }

    @Test
    void 공백_입력() {
        assertThatThrownBy(() -> runException("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Test
    void 특수_입력() {
        assertThatThrownBy(() -> runException("//"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 값이 포함되어있습니다.");
    }

    @Test
    void 빈_문자열() {
        assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Test
    void 구분자_연속() {
        assertThatThrownBy(() -> runException("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열을 입력했습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}