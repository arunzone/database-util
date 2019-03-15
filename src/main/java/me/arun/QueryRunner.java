package me.arun;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryRunner {

    private FileReader fileReader;
    private Database database;

    public QueryRunner(FileReader fileReader, Database database) {
        this.fileReader = fileReader;
        this.database = database;
    }

    public List<List<Map<String, Object>>> runQueries() throws IOException {
        return fileReader.readDirectory(".").parallelStream().
                map(command -> database.executeQuery(command)).
                collect(Collectors.toList());
    }
}
