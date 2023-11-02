package com.example.task_10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    public ListView<String> demolist;

    @FXML
    private TextField inputField;
    private Adapter<Integer> demo; // Используем Adapter для Integer (или другого типа данных)

    public HelloController()
    {
        demo = new OrdArrayAdapter<>();
    }

    @FXML
    private void onInsertClick(ActionEvent event) {
        String input = inputField.getText();
        if (!input.isEmpty()) {
            int item = Integer.parseInt(input);
            insertItem(item);
        }
    }

    @FXML
    private void onDeleteClick(ActionEvent event) {
        String input = inputField.getText();
        if (!input.isEmpty()) {
            int item = Integer.parseInt(input);
            removeItem(item);
        }
    }

    @FXML
    private void onSearchClick(ActionEvent event) {
        String input = inputField.getText();
        if (!input.isEmpty()) {
            int item = Integer.parseInt(input);
            findItem(item);
        }
    }

    public void insertItem(int item) {
        demo.insert(item);
        updateListView();
    }

    public void removeItem(int item) {
        demo.remove(item);
        updateListView();
    }

    public void findItem(int item) {
        Integer foundItem = demo.find(item);
        if (foundItem != null) {
            System.out.println("Item found: " + foundItem);
        } else {
            System.out.println("Item not found.");
        }
    }

    private void updateListView() {
        demolist.getItems().clear();
        demolist.getItems().addAll(demo.display());
    }
}