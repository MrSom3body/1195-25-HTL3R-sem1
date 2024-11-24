package secondtry;

import org.junit.jupiter.api.Test;

public class WordCountTests {
    @Test
    void testWordCount() {
        WordCount wordCount = new WordCount();
        // leicht
        assertEquals(0, wordCount.count(""));
        assertEquals(0, wordCount.count(" "));
        assertEquals(0, wordCount.count("  "));

        // normal
        assertEquals(1, wordCount.count("one"));
        assertEquals(1, wordCount.count(" one"));
        assertEquals(1, wordCount.count("one "));
        assertEquals(1, wordCount.count(" one "));
        assertEquals(1, wordCount.count(" one  "));
        assertEquals(1, wordCount.count("  one "));
        assertEquals(1, wordCount.count("  one  "));

        assertEquals(1, wordCount.count("one:"));
        assertEquals(1, wordCount.count(":one"));
        assertEquals(1, wordCount.count(":one:"));
        assertEquals(1, wordCount.count(" one  "));
        assertEquals(1, wordCount.count(" one : "));
        assertEquals(1, wordCount.count(": one :"));
        assertEquals(3, wordCount.count("ein erster Text"));
        assertEquals(3, wordCount.count(" ein  erster   Text      "));
        assertEquals(3, wordCount.count("ein:erster.Text"));

        // vielleicht falsch
        assertEquals(1, wordCount.count("a"));
        assertEquals(1, wordCount.count(" a"));
        assertEquals(1, wordCount.count("a "));
        assertEquals(1, wordCount.count(" a "));

        // mit html
        assertEquals(1, wordCount.count(" one  <html> "));
        assertEquals(1, wordCount.count(" one  < html> "));
        assertEquals(1, wordCount.count(" one  <html > "));
        assertEquals(1, wordCount.count(" one  < html > "));
        assertEquals(4, wordCount.count(" one <html> two<html>three <html> four"));

        assertEquals(2, wordCount.count(" one <html> two "));
        assertEquals(2, wordCount.count(" one <html>two "));
        assertEquals(2, wordCount.count(" one<html> two "));
        assertEquals(2, wordCount.count(" one<html>two "));
        assertEquals(2, wordCount.count(" one<img alt=\"xxx\" > two"));
        assertEquals(2, wordCount.count(" one<img alt=\"xxx yyy\" > two"));

        assertEquals(2, wordCount.count(" one \"two\" "));
        assertEquals(2, wordCount.count(" one\"two\" "));
        assertEquals(2, wordCount.count(" one \"two\""));
        assertEquals(3, wordCount.count(" one \"two\"three"));
        assertEquals(3, wordCount.count(" one \"two\" three"));

        // html - trickreich
        // Achtung: das ist teilweise nicht ganz legales HTML
        assertEquals(1, wordCount.count(" one<html")); // kein >

        assertEquals(2, wordCount.count(" one<img alt=\"<bild>\" > two")); // <> innerhalb ""
        assertEquals(2, wordCount.count(" one<img alt=\"bild>\" > two"));  // <> innerhalb ""
        assertEquals(2, wordCount.count(" one<img alt=\"<bild>\" keinwort> two"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort>two"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort> two"));

        assertEquals(1, wordCount.count(" one<img alt=\"<bild\" keinwort"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild\" keinwort> two"));
        assertEquals(1, wordCount.count(" one<img alt=\"<bild keinwort> keinwort"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild keinwort keinwort\">two"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild keinwort< keinwort\">two"));

        // ganz ganz fies -- \ entwertet das nächste Zeichen
        assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort> keinwort\" keinwort>two"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort<keinwort\" keinwort>two"));
        assertEquals(2, wordCount.count(" one<img alt=\"<bild \\\" keinwort keinwort\" keinwort>two"));

        assertEquals(4, wordCount.count(" \\\"null\\\" one<img alt=\"<bild \\\" keinwort keinwort\" keinwort>two \"three\""));
    }
}
