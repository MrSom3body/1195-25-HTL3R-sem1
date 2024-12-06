package csv;

import java.util.ArrayList;

public class CSVReader {
    private final char delimeter;
    private final char doublequote;
    private final boolean skipinitalwhitespace;

    private ArrayList<String> words;
    private String word;

    enum State {
        READING {
            State handleChar(char ch, CSVReader context) {
                if (ch == context.delimeter || ch == '\0') {
                    context.words.add(context.word);
                    context.word = "";
                    return READING;
                } else if (ch == context.doublequote) {
                    return QUOTED;
                } else {
                    context.word += ch;
                    return this;
                }
            }
        }, QUOTED {
            State handleChar(char ch, CSVReader context) {
                if (ch == '\0') {
                    throw new IllegalArgumentException("Open quote after: " + ch);
                } else if (ch == context.doublequote) {
                    context.words.add(context.word);
                    context.word = "";
                    return DISABLE_QUOTED;
                } else {
                    context.word += ch;
                    return this;
                }
            }
        }, DISABLE_QUOTED {
            State handleChar(char ch, CSVReader context) {
                if (ch == '\0') {
                    return DISABLE_QUOTED;
                } else if (ch == context.delimeter) {
                    return READING;
                } else {
                    throw new IllegalArgumentException("Unexpected token after closing quote: " + ch);
                }
            }
        };

        abstract State handleChar(char ch, CSVReader context);
    }

    public CSVReader(char delimeter, char doublequote, boolean skipinitwhitespace) {
        this.delimeter = delimeter;
        this.doublequote = doublequote;
        this.skipinitalwhitespace = skipinitwhitespace;
    }

    public String[] read(String input) {
        word = "";
        words = new ArrayList<>();
        State state = State.READING;
        String modInput = input + "\0";

        for (char ch : modInput.toCharArray()) {
            state = state.handleChar(ch, this);
        }

        return words.toArray(new String[0]);
    }
}
