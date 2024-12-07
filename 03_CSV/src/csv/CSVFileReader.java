package csv;

import java.io.*;

public class CSVFileReader {
    private final CSVReader reader;
    private final BufferedReader fileReader;

    public CSVFileReader(String filename, char delimeter, char doublequote, boolean skipinitalwhitespace) throws FileNotFoundException {
        reader = new CSVReader(delimeter, doublequote, skipinitalwhitespace);
        fileReader = new BufferedReader(new FileReader(filename));
    }

    public String[] next() throws IOException {
        String fileLine = fileReader.readLine();
        if (fileLine == null) {
            return new String[0];
        } else {
            return reader.read(fileLine);
        }
    }
}
