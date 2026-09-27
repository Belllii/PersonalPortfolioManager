package com.portfolio;

import com.portfolio.database.NoteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NotesController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Note> noteList;

    private final NoteDAO noteDAO = new NoteDAO();

    private final ObservableList<Note> notes =
            FXCollections.observableArrayList();

    private Note selectedNote;

    @FXML
    public void initialize() {

        noteList.setItems(notes);

        loadNotes();

        noteList.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldNote, newNote) -> {

                            if (newNote != null) {

                                selectedNote = newNote;

                                titleField.setText(
                                        newNote.getTitle()
                                );

                                contentArea.setText(
                                        newNote.getContent()
                                );
                            }
                        }
                );
    }

    private void loadNotes() {

        notes.setAll(
                noteDAO.getAllNotes()
        );
    }

    @FXML
    private void addNote() {

        String title =
                titleField.getText().trim();

        String content =
                contentArea.getText();

        if (title.isEmpty()) {
            showMessage("Please enter a note title.");
            return;
        }

        Note note =
                new Note(title, content);

        noteDAO.insertNote(note);

        loadNotes();
        clearFields();
    }

    @FXML
    private void updateNote() {

        if (selectedNote == null) {
            showMessage("Please select a note first.");
            return;
        }

        String title =
                titleField.getText().trim();

        String content =
                contentArea.getText();

        if (title.isEmpty()) {
            showMessage("Please enter a note title.");
            return;
        }

        Note updatedNote =
                new Note(title, content);

        noteDAO.updateNote(
                selectedNote.getId(),
                updatedNote
        );

        loadNotes();
        clearFields();
    }

    @FXML
    private void deleteNote() {

        if (selectedNote == null) {
            showMessage("Please select a note first.");
            return;
        }

        noteDAO.deleteNote(
                selectedNote.getId()
        );

        loadNotes();
        clearFields();
    }

    @FXML
    private void clearFields() {

        titleField.clear();
        contentArea.clear();

        selectedNote = null;

        noteList.getSelectionModel()
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