package me.arun.database;

import me.arun.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private DriverType driverType;
    private Connection connection;

    public Database(DriverType driverType) {
        this.driverType = driverType;
        establishConnection();
    }

    public Connection connection() {
        return connection;
    }

    private void establishConnection() {
        try {
            Class.forName(driverType.getDriverName());
            connection = DriverManager.getConnection(driverType.getDriverUrl(), "aconexsql", "aconexsql");
        } catch (Exception e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
    }


    public List<Map<String, Object>> executeQuery(String query) {
        List<Map<String, Object>> result;
        try {
            Statement statement = connection().createStatement();
            result = resultSetToList(statement.executeQuery(query));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException();
        }
        return result;
    }

    private List<Map<String, Object>> resultSetToList(ResultSet resultSet) throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        int columnsCount = metaData.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<String, Object>(columnsCount);
            for (int i = 1; i <= columnsCount; ++i) {
                row.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
}
