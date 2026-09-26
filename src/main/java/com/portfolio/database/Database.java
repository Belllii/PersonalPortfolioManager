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

        String projectsSql = """
            CREATE TABLE IF NOT EXISTS projects (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                description TEXT NOT NULL,
                technology TEXT NOT NULL,
                github_link TEXT
            )
            """;

        String skillsSql = """
            CREATE TABLE IF NOT EXISTS skills (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                category TEXT NOT NULL,
                level INTEGER NOT NULL
            )
            """;

        String projectSkillsSql = """
            CREATE TABLE IF NOT EXISTS project_skills (
                project_id INTEGER NOT NULL,
                skill_id INTEGER NOT NULL,
                PRIMARY KEY (project_id, skill_id),
                FOREIGN KEY (project_id)
                    REFERENCES projects(id)
                    ON DELETE CASCADE,
                FOREIGN KEY (skill_id)
                    REFERENCES skills(id)
                    ON DELETE CASCADE
            )
            """;

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(projectsSql);
            statement.execute(skillsSql);
            statement.execute(projectSkillsSql);

            System.out.println(
                    "Database tables created successfully."
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}