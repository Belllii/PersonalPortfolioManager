package com.portfolio;

import com.portfolio.database.TaskDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TasksController {

    @FXML
    private TextField titleField;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private ListView<TaskItem> taskList;

    private final TaskDAO taskDAO =
            new TaskDAO();

    private final ObservableList<TaskItem> tasks =
            FXCollections.observableArrayList();

    private TaskItem selectedTask;

    @FXML
    public void initialize() {

        taskList.setItems(tasks);

        loadTasks();

        taskList.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldTask, newTask) -> {

                            if (newTask != null) {

                                selectedTask = newTask;

                                titleField.setText(
                                        newTask.getTitle()
                                );

                                completedCheckBox.setSelected(
                                        newTask.isCompleted()
                                );
                            }
                        }
                );
    }

    private void loadTasks() {

        tasks.setAll(
                taskDAO.getAllTasks()
        );
    }

    @FXML
    private void addTask() {

        String title =
                titleField.getText().trim();

        if (title.isEmpty()) {
            showMessage("Please enter a task title.");
            return;
        }

        TaskItem task =
                new TaskItem(
                        title,
                        completedCheckBox.isSelected()
                );

        taskDAO.insertTask(task);

        loadTasks();
        clearFields();
    }

    @FXML
    private void updateTask() {

        if (selectedTask == null) {
            showMessage("Please select a task first.");
            return;
        }

        String title =
                titleField.getText().trim();

        if (title.isEmpty()) {
            showMessage("Please enter a task title.");
            return;
        }

        TaskItem updatedTask =
                new TaskItem(
                        title,
                        completedCheckBox.isSelected()
                );

        taskDAO.updateTask(
                selectedTask.getId(),
                updatedTask
        );

        loadTasks();
        clearFields();
    }

    @FXML
    private void deleteTask() {

        if (selectedTask == null) {
            showMessage("Please select a task first.");
            return;
        }

        taskDAO.deleteTask(
                selectedTask.getId()
        );

        loadTasks();
        clearFields();
    }

    @FXML
    private void clearFields() {

        titleField.clear();
        completedCheckBox.setSelected(false);

        selectedTask = null;

        taskList.getSelectionModel()
                .clearSelection();
    }

    private void showMessage(String message) {

        Alert alert = new Alert(
                Alert.AlertType.INFORMATION
        );

        alert.setTitle("Portfolio Manager");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}