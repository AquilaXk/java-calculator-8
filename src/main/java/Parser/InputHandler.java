package Parser;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputHandler {

    private static final String DEFAULT_DELIMITER = ",|:";
    private String delimiter = DEFAULT_DELIMITER;
    private String input;

    public InputHandler() {
        input = Console.readLine();
    }

    public InputHandler(String input) {
        this.input = input;
    }

    private void parseDelimiter() {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }
    }

    public String[] parseTokens() {
        parseDelimiter();
        return input.split(Pattern.quote(delimiter));
    }

}
