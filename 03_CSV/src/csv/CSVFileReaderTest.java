package csv;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CSVFileReaderTest {
    @Test
    public void testNext() throws IOException {
        CSVFileReader reader = new CSVFileReader("resources/adjacency.csv", ';', '"', true);
        assertArrayEquals(new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H"}, reader.next());
        assertArrayEquals(new String[]{"A", "", "4", "7", "8", "", "", "", ""}, reader.next());
        assertArrayEquals(new String[]{"B", "4", "", "", "", "5", "3", "", ""}, reader.next());
        assertArrayEquals(new String[]{"C", "7", "", "", "2", "", "", "1", ""}, reader.next());
        assertArrayEquals(new String[]{"D", "8", "5", "2", "", "1", "", "2", ""}, reader.next());
        assertArrayEquals(new String[]{"E", "", "3", "", "1", "", "1", "", "5"}, reader.next());
        assertArrayEquals(new String[]{"F", "", "3", "", "", "1", "", "", "1"}, reader.next());
        assertArrayEquals(new String[]{"G", "", "", "1", "2", "", "", "", "1"}, reader.next());
        assertArrayEquals(new String[]{"H", "", "", "", "", "5", "1", "1", ""}, reader.next());
        assertArrayEquals(new String[0], reader.next());
    }

    @Test
    public void testNextWithTry() {
        try (CSVFileReader reader = new CSVFileReader("resources/adjacency.csv", ';', '"', true)) {
            assertArrayEquals(new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H"}, reader.next());
            assertArrayEquals(new String[]{"A", "", "4", "7", "8", "", "", "", ""}, reader.next());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
