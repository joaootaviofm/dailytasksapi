package dev.joao.dailytasks.controller;


import dev.joao.dailytasks.model.Task;
import dev.joao.dailytasks.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        var createdTask = taskService.createNewTask(task);

        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") UUID id) {
        var task = taskService.getTask(id);

        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/id")
    public void deleteTask(@PathVariable("id") UUID id){
        taskService.deleteTask(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteTasks(){
        taskService.deleteTasks();
    }
}
