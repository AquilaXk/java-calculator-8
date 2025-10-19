package calculator.parser;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {


    @Test
    void 기본_구분자_콜론_입력() {
        String str = "1:2:3";
        InputHandler inputHandler = new InputHandler(str);
        assertThat(inputHandler.parseTokens()).containsExactly("1", "2", "3");
    }

    @Test
    void 기본_구분자_혼합_입력() {
        String str = "1,2:3";
        InputHandler inputHandler = new InputHandler(str);
        assertThat(inputHandler.parseTokens()).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자_입력() {
        String str = "//;\n1;2;3";
        InputHandler inputHandler = new InputHandler(str);
        assertThat(inputHandler.parseTokens()).containsExactly("1", "2", "3");
    }

    @Test
    void 커스텀_구분자가_정규식_특수문자일_경우() {
        String str = "//.\n1.2.3";
        InputHandler inputHandler = new InputHandler(str);
        assertThat(inputHandler.parseTokens()).containsExactly("1", "2", "3");
    }
}
