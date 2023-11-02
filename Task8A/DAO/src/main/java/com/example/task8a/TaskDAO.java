package com.example.task8a;

import java.util.List;

public interface TaskDAO {

    List<Task> getAllTasks();

    void addTask(Task task);

    void drop();

}