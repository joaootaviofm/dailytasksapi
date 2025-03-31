package dev.joao.dailytasks.service;

import dev.joao.dailytasks.repository.TaskRepository;

public class TaskService {

    TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


}
