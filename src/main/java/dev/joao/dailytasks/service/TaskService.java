package dev.joao.dailytasks.service;

import dev.joao.dailytasks.model.Task;
import dev.joao.dailytasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createNewTask(Task task){
        if(task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        return taskRepository.save(task);
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(UUID id){
        return taskRepository.findById(id);
    }

    public void deleteTask(UUID id){
        taskRepository.deleteById(id);
    }

    public void deleteTasks(){
        taskRepository.deleteAll();
    }








}
