package me.arun.database;

public enum DriverType {
    JTDS("net.sourceforge.jtds.jdbc.Driver", "jdbc:jtds:sqlserver://localhost/babylon"),
    MSSQ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost;database=babylon");

    private String driverName;
    private String driverUrl;

    DriverType(String driverName, String driverUrl) {
        this.driverName = driverName;
        this.driverUrl = driverUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverUrl() {
        return driverUrl;
    }
}
