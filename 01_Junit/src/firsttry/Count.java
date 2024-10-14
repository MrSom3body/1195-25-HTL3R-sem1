package firsttry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
    public static long count(String text) {
        // text = text.replaceAll("(?<!\")<.*?>(?!\")", " ");
        text = text.replaceAll("< *(\\w+)( +\\w+=\".*\")?( +\\w+)* *>", " ");
        text = text.replaceAll("(?<!\")<.*", "");

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(text);
        return m.results().count();
    }
}
