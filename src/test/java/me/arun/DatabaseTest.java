package me.arun;

import me.arun.database.Database;
import me.arun.database.DriverType;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DatabaseTest {
    @Test
    public void shouldExecuteQueryUsingJtds() {
        Database database = new Database(DriverType.JTDS);

        List<Map<String, Object>> result = database.executeQuery("select * from userx");

        assertThat(result, is(not(empty())));
    }

    @Test
    public void shouldExecuteQueryUsingMSSql() {
        Database database = new Database(DriverType.MSSQ);

        List<Map<String, Object>> result = database.executeQuery("select * from userx");

        assertThat(result, is(not(empty())));
    }

}