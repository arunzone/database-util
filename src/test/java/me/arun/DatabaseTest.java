package me.arun;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertThat;

public class DatabaseTest {
    @Test
    public void shouldReturnDatabaseConnection() throws SQLException, ClassNotFoundException {
        Database database = new Database(DriverType.JTDS);

        assertThat(database.connection(), Is.isA(Connection.class));
    }

}