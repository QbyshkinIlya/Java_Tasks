package com.example.task8a;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileTaskDAO implements TaskDAO {
    private String fileName;
    private List<Task> tasks;

    public FileTaskDAO(String fileName) {
        this.fileName = fileName;
        this.tasks = new ArrayList<>();
        loadTasksFromFile();
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Загрузка задач из файла и заполнение списка tasks
    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseTaskFromLine(line);
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(Task task) {
        int maxId = tasks.stream().mapToInt(Task::getId).max().orElse(0);
        task.setId(maxId + 1);
        tasks.add(task);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task t : tasks) {
                String line = taskToString(t);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Task parseTaskFromLine(String line) {
        if (line != null && line.contains(",")) {
            String[] parts = line.split(",");
            if (parts.length == 4)
            {
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String time = parts[2];
                String status = parts[3];
            return new Task(id, name, time, status);
            } else {
                System.err.println("Incorrect number of parts in the line: " + line);
            }
        } else {
            System.err.println("Invalid line format: " + line);
        }
        return null;
    }
    public void updateFileFromList() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task t : tasks) {
                String line = taskToString(t);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String taskToString(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(task.getId()).append(",");
        sb.append(task.getName()).append(",");
        sb.append(task.getTime()).append(",");
        sb.append(task.getStatus());
        return sb.toString();
    }

    @Override
    public void drop() {
        // Удалить все задачи из списка
        tasks.clear();

        // Теперь обновить файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task t : tasks) {
                String line = taskToString(t);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
