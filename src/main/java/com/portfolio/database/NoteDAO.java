package com.portfolio.database;

import com.portfolio.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    public void insertNote(Note note) {

        String sql = """
                INSERT INTO notes
                (title, content)
                VALUES (?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContent());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Note> getAllNotes() {

        List<Note> notes = new ArrayList<>();

        String sql = "SELECT * FROM notes";

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet =
                     statement.executeQuery()) {

            while (resultSet.next()) {

                Note note = new Note(
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );

                note.setId(
                        resultSet.getInt("id")
                );

                notes.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    public void updateNote(
            int id,
            Note note) {

        String sql = """
                UPDATE notes
                SET title = ?,
                    content = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, note.getTitle());
            statement.setString(2, note.getContent());
            statement.setInt(3, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNote(int id) {

        String sql =
                "DELETE FROM notes WHERE id = ?";

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