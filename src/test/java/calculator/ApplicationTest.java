package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과값 : 6");
        });
    }


    @Test
    void 기본_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과값 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과값 : 10");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("   ");
            assertThat(output()).contains("결과값 : 10");
        });
    }

    @Test
    void 숫자_0_입력() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과값 : 0");
        });
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
