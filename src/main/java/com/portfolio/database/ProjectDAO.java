package com.portfolio.database;

import com.portfolio.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    // CREATE

    public void insertProject(Project project) {

        String sql = """
                INSERT INTO projects
                (title, description, technology, github_link)
                VALUES (?, ?, ?, ?)
                """;


        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    project.getTitle()
            );

            statement.setString(
                    2,
                    project.getDescription()
            );

            statement.setString(
                    3,
                    project.getTechnology()
            );

            statement.setString(
                    4,
                    project.getGithubLink()
            );


            statement.executeUpdate();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    // READ
    public List<Project> getAllProjects() {

        List<Project> projects =
                new ArrayList<>();


        String sql =
                "SELECT * FROM projects";


        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet =
                     statement.executeQuery()) {


            while (resultSet.next()) {

                Project project =
                        new Project(

                                resultSet.getString(
                                        "title"
                                ),

                                resultSet.getString(
                                        "description"
                                ),

                                resultSet.getString(
                                        "technology"
                                ),

                                resultSet.getString(
                                        "github_link"
                                )
                        );


                // Get database ID
                project.setId(
                        resultSet.getInt("id")
                );


                projects.add(project);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }


        return projects;
    }
    // UPDATE
    public void updateProject(
            int id,
            Project project) {
        String sql = """
                UPDATE projects
                SET title = ?,
                    description = ?,
                    technology = ?,
                    github_link = ?
                WHERE id = ?
                """;
        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {
            statement.setString(
                    1,
                    project.getTitle()
            );

            statement.setString(
                    2,
                    project.getDescription());

            statement.setString(
                    3,
                    project.getTechnology());

            statement.setString(
                    4,
                    project.getGithubLink());

            statement.setInt(
                    5,
                    id);
            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    // DELETE
    public void deleteProject(int id) {
        String sql =
                "DELETE FROM projects WHERE id = ?";
        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {
            statement.setInt(
                    1,
                    id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}