package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTests {
    @Test
    public void testCountSimple() {
        WordCount wordCount = new WordCount();
        assertEquals(0, wordCount.count(""));
        assertEquals(0, wordCount.count("1337"));
        assertEquals(3, wordCount.count("Das sind 3 Wörter"));
    }
}
