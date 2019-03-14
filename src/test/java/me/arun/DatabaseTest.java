package me.arun;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DatabaseTest {
    @Test
    public void shouldReturnDatabaseConnection() throws SQLException, ClassNotFoundException {
        Database database = new Database(DriverType.JTDS);

        assertThat(database.connection(), Is.isA(Connection.class));
    }

    @Test
    public void shouldExecuteQuery() throws SQLException, ClassNotFoundException {
        Database database =  new Database(DriverType.JTDS);

        List<Map<String, Object>> result = database.executeQuery("select * from userx");

        assertThat(result, is(not(empty())));
    }

}