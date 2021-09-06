package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Config config = new Config(
                    "C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\jdbc\\app.properties"
            );
            config.load();
            connection = DriverManager.getConnection(
                    config.value("url"),
                    config.value("login"),
                    config.value("password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void statementExecute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = String.format(
                "create table if not exists table %s;",
                tableName
        );
        statementExecute(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format(
                "delete table if exists table %s;",
                tableName
        );
        statementExecute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "add column(name %s, type %s) in table %s;",
                columnName,
                type,
                tableName
        );
        statementExecute(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format(
                "delete column %s in table %s;",
                columnName,
                tableName
        );
        statementExecute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                "rename column %s to %s in table(%s);",
                columnName,
                newColumnName,
                tableName
        );
        statementExecute(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}