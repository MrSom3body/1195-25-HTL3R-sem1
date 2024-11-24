package secondtry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCountTests {
    @Test
    void testWordCount() {
        WordCount wordCount = new WordCount();
        // leicht
        Assertions.assertEquals(0, wordCount.count(""));
        Assertions.assertEquals(0, wordCount.count(" "));
        Assertions.assertEquals(0, wordCount.count("  "));

        // normal
        Assertions.assertEquals(1, wordCount.count("one"));
        Assertions.assertEquals(1, wordCount.count(" one"));
        Assertions.assertEquals(1, wordCount.count("one "));
        Assertions.assertEquals(1, wordCount.count(" one "));
        Assertions.assertEquals(1, wordCount.count(" one  "));
        Assertions.assertEquals(1, wordCount.count("  one "));
        Assertions.assertEquals(1, wordCount.count("  one  "));

        Assertions.assertEquals(1, wordCount.count("one:"));
        Assertions.assertEquals(1, wordCount.count(":one"));
        Assertions.assertEquals(1, wordCount.count(":one:"));
        Assertions.assertEquals(1, wordCount.count(" one  "));
        Assertions.assertEquals(1, wordCount.count(" one : "));
        Assertions.assertEquals(1, wordCount.count(": one :"));
        Assertions.assertEquals(3, wordCount.count("ein erster Text"));
        Assertions.assertEquals(3, wordCount.count(" ein  erster   Text      "));
        Assertions.assertEquals(3, wordCount.count("ein:erster.Text"));

        // vielleicht falsch
        Assertions.assertEquals(1, wordCount.count("a"));
        Assertions.assertEquals(1, wordCount.count(" a"));
        Assertions.assertEquals(1, wordCount.count("a "));
        Assertions.assertEquals(1, wordCount.count(" a "));

        // mit html
        Assertions.assertEquals(1, wordCount.count(" one  <html> "));
        Assertions.assertEquals(1, wordCount.count(" one  < html> "));
        Assertions.assertEquals(1, wordCount.count(" one  <html > "));
        Assertions.assertEquals(1, wordCount.count(" one  < html > "));
        Assertions.assertEquals(4, wordCount.count(" one <html> two<html>three <html> four"));

        Assertions.assertEquals(2, wordCount.count(" one <html> two "));
        Assertions.assertEquals(2, wordCount.count(" one <html>two "));
        Assertions.assertEquals(2, wordCount.count(" one<html> two "));
        Assertions.assertEquals(2, wordCount.count(" one<html>two "));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"xxx\" > two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"xxx yyy\" > two"));

        Assertions.assertEquals(2, wordCount.count(" one \"two\" "));
        Assertions.assertEquals(2, wordCount.count(" one\"two\" "));
        Assertions.assertEquals(2, wordCount.count(" one \"two\""));
        Assertions.assertEquals(3, wordCount.count(" one \"two\"three"));
        Assertions.assertEquals(3, wordCount.count(" one \"two\" three"));

        // html - trickreich
        // Achtung: das ist teilweise nicht ganz legales HTML
        Assertions.assertEquals(1, wordCount.count(" one<html")); // kein >

        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild>\" > two")); // <> innerhalb ""
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"bild>\" > two"));  // <> innerhalb ""
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild>\" keinwort> two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort>two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort> two"));

        Assertions.assertEquals(1, wordCount.count(" one<img alt=\"<bild\" keinwort"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort> two"));
        Assertions.assertEquals(1, wordCount.count(" one<img alt=\"<bild keinwort> keinwort"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild keinwort keinwort\">two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild keinwort< keinwort\">two"));

        // ganz ganz fies -- \ entwertet das nächste Zeichen
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort<keinwort\" keinwort>two"));
        Assertions.assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort keinwort\" keinwort>two"));

        Assertions.assertEquals(4, wordCount.count(" \\\"null\\\" one<img alt=\"<bild \\\" keinwort keinwort\" keinwort>two \"three\""));
    }
}
