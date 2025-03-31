package dev.joao.dailytasks.repository;

import dev.joao.dailytasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
