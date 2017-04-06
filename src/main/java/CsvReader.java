import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kaustubh on 3/31/17.
 */
public class CsvReader {
    CSVReader reader = null;
    ArrayList headers = null;
    ArrayList<ArrayList<String>> columns = null;
    int numColumns = 0;
    int numRows = 0;


    CsvReader(FileReader file) throws IOException {
        reader = new CSVReader(file);
        columns = new ArrayList<ArrayList<String>>();
        headers = new ArrayList();
        getHeaders();
        initColumns();
    }

    public ArrayList getHeaders() {
        if (headers == null) {
            headers = new ArrayList();
            try {
                headers.add(Arrays.asList(reader.readNext()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return headers;
    }

    private void initColumns() throws IOException {
        String nextLine[] = reader.readNext();
        while (nextLine != null) {
            int i = 0;
            for (String value : nextLine) {
                columns.get(i++).add(value);
            }
        }

    }

    public ArrayList getColumn(int index) {
        return columns.get(index);
    }

    public String[] getNextRow() throws IOException {
        return reader.readNext();
    }

}
