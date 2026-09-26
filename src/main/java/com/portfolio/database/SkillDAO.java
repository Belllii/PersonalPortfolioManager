package com.portfolio.database;

import com.portfolio.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    public void insertSkill(Skill skill) {

        String sql = """
                INSERT INTO skills
                (name, category, level)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, skill.getName());
            statement.setString(2, skill.getCategory());
            statement.setInt(3, skill.getLevel());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getAllSkills() {

        List<Skill> skills = new ArrayList<>();

        String sql = "SELECT * FROM skills";

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet =
                     statement.executeQuery()) {

            while (resultSet.next()) {

                Skill skill = new Skill(
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("level")
                );

                skill.setId(
                        resultSet.getInt("id")
                );

                skills.add(skill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }

    public void updateSkill(
            int id,
            Skill skill) {

        String sql = """
                UPDATE skills
                SET name = ?,
                    category = ?,
                    level = ?
                WHERE id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, skill.getName());
            statement.setString(2, skill.getCategory());
            statement.setInt(3, skill.getLevel());
            statement.setInt(4, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSkill(int id) {

        String sql =
                "DELETE FROM skills WHERE id = ?";

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignSkillToProject(
            int projectId,
            int skillId) {

        String sql = """
                INSERT OR IGNORE INTO project_skills
                (project_id, skill_id)
                VALUES (?, ?)
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, projectId);
            statement.setInt(2, skillId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Skill> getSkillsForProject(
            int projectId) {

        List<Skill> skills = new ArrayList<>();

        String sql = """
                SELECT s.*
                FROM skills s
                JOIN project_skills ps
                ON s.id = ps.skill_id
                WHERE ps.project_id = ?
                """;

        try (Connection connection = Database.connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, projectId);

            ResultSet resultSet =
                    statement.executeQuery();

            while (resultSet.next()) {

                Skill skill = new Skill(
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("level")
                );

                skill.setId(
                        resultSet.getInt("id")
                );

                skills.add(skill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skills;
    }
}