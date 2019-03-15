package me.arun;

import me.arun.database.Database;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryRunnerTest {
    @Test
    public void shouldReadAndExecuteQueries() throws IOException {
        FileReader fileReader = mock(FileReader.class);
        Database database = mock(Database.class);
        QueryRunner queryRunner = new QueryRunner(fileReader, database);
        when(fileReader.readDirectory(anyString())).thenReturn(Collections.singletonList("select * from userx"));
        List<Map<String, Object>> result = Collections.singletonList(new HashMap<>());
        when(database.executeQuery("select * from userx")).thenReturn(result);

        MatcherAssert.assertThat(queryRunner.runQueriesFrom("."), hasItem(result));
    }
}