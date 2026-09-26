package com.portfolio.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL =
            "jdbc:sqlite:portfolio.db";


    public static Connection connect()
            throws SQLException {

        return DriverManager.getConnection(URL);
    }


    public static void createTables() {

        String sql = """
                CREATE TABLE IF NOT EXISTS projects (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    description TEXT NOT NULL,
                    technology TEXT NOT NULL,
                    github_link TEXT
                )
                """;


        try (Connection connection = connect();
             Statement statement =
                     connection.createStatement()) {

            statement.execute(sql);

            System.out.println(
                    "Projects table created successfully."
            );

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}