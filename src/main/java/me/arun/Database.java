package me.arun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private DriverType driverType;

    public Database(DriverType driverType) {
        this.driverType = driverType;
    }

    public Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName(driverType.getDriverName());
        return DriverManager.getConnection(driverType.getDriverUrl(), "aconexsql", "aconexsql");
    }


}
