package me.arun;

import me.arun.database.Database;
import me.arun.database.DriverType;

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

    public static void main(String[] args) throws IOException {
        List<List<Map<String, Object>>> result = new QueryRunner(new FileReader(), new Database(DriverType.JTDS)).runQueriesFrom("./src/test/resources/");
        result.forEach(System.out::println);
    }

    public List<List<Map<String, Object>>> runQueriesFrom(String directoryName) throws IOException {
        return fileReader.readDirectory(directoryName).parallelStream().
                map(command -> database.executeQuery(command)).
                collect(Collectors.toList());
    }
}
