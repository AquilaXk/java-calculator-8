package calculator.parser;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputHandler {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final String originalInput;

    private String finalDelimiter;
    private String parsableInput;
    private boolean isParsed = false;


    public InputHandler() {
        String firstLine = Console.readLine();
        String lastLine;
        if (firstLine.startsWith("//")) {
            lastLine = firstLine + "\n" + Console.readLine();
        } else {
            lastLine = firstLine;
        }
        this.originalInput = lastLine;
    }

    public InputHandler(String input) {
        this.originalInput = input;
    }

    private void parseInputAndDelimiter() {
        if (isParsed) {
            return;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(originalInput);

        if (matcher.matches()) {
            this.finalDelimiter = Pattern.quote(matcher.group(1));
            this.parsableInput = matcher.group(2);
        } else {
            this.finalDelimiter = DEFAULT_DELIMITER;
            this.parsableInput = originalInput;
        }
        this.isParsed = true;
    }

    public String[] parseTokens() {
        parseInputAndDelimiter();

        return parsableInput.split(finalDelimiter);
    }

}