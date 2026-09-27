package com.portfolio.database;

import com.portfolio.TaskItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void insertTask(TaskItem task) {

        String sql = """
                INSERT INTO tasks
                (title, completed, priority)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, task.getTitle());
            statement.setInt(
                    2,
                    task.isCompleted() ? 1 : 0
            );
            statement.setString(3, task.getPriority());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TaskItem> getAllTasks() {

        List<TaskItem> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks";

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet =
                     statement.executeQuery()) {

            while (resultSet.next()) {

                String priority = "Medium";
                try {
                    String p = resultSet.getString("priority");
                    if (p != null && !p.isBlank()) {
                        priority = p;
                    }
                } catch (SQLException ignored) {
                }

                TaskItem task = new TaskItem(
                        resultSet.getString("title"),
                        resultSet.getInt("completed") == 1,
                        priority
                );

                task.setId(
                        resultSet.getInt("id")
                );

                tasks.add(task);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    public void updateTask(
            int id,
            TaskItem task) {

        String sql = """
                UPDATE tasks
                SET title = ?,
                    completed = ?,
                    priority = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, task.getTitle());

            statement.setInt(
                    2,
                    task.isCompleted() ? 1 : 0
            );

            statement.setString(3, task.getPriority());

            statement.setInt(4, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id) {

        String sql =
                "DELETE FROM tasks WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}