package csv;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSVFileReader implements Closeable, Iterable<String[]> {
    private final CSVReader reader;
    private final BufferedReader fileReader;

    public CSVFileReader(String filename, char delimiter, char doublequote, boolean skipinitalwhitespace) throws FileNotFoundException {
        reader = new CSVReader(delimiter, doublequote, skipinitalwhitespace);
        fileReader = new BufferedReader(new FileReader(filename));
    }

    public String[] next() throws IOException {
        String fileLine = fileReader.readLine();
        return fileLine != null ? reader.read(fileLine) : null;
    }

    @Override
    public void close() throws IOException {
        fileReader.close();
    }

    public Iterator<String[]> iterator() {
        return new Iterator<>() {
            private String[] nextLine = fetchNextLine();

            private String[] fetchNextLine() {
                try {
                    return CSVFileReader.this.next();
                } catch (IOException e) {
                    throw new RuntimeException("Error reading the CSV file", e);
                }
            }

            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String[] next() {
                if (nextLine == null) {
                    throw new NoSuchElementException("No more lines to read");
                }
                String[] currentLine = nextLine;
                nextLine = fetchNextLine();
                return currentLine;
            }
        };
    }
}
