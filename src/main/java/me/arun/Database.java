package me.arun;

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

    public Database(DriverType driverType) throws SQLException, ClassNotFoundException {
        this.driverType = driverType;
        this.connection = establishConnection();
    }

    public Connection connection(){
        return connection;
    }
    private Connection establishConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driverType.getDriverName());
        return DriverManager.getConnection(driverType.getDriverUrl(), "aconexsql", "aconexsql");
    }


    public List<Map<String, Object>> executeQuery(String query) throws SQLException {
        Statement stmt=connection().createStatement();
        return resultSetToList(stmt.executeQuery(query));
    }

    private List<Map<String, Object>> resultSetToList(ResultSet resultSet) throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        int columnsCount = metaData.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (resultSet.next()){
            Map<String, Object> row = new HashMap<String, Object>(columnsCount);
            for(int i = 1; i <= columnsCount; ++i){
                row.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }
}
