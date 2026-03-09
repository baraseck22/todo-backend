package com.bara.todo.controller;

import com.bara.todo.dto.TaskDTO;
import com.bara.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")  // tous les endpoints commencent par /tasks
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @PostMapping  // POST /tasks
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO dto){
        return ResponseEntity.ok(service.createTask(dto));
    }

    @GetMapping  // GET /tasks
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/{id}")  // GET /tasks/{id}
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTaskById(id));
    }

    @PutMapping("/{id}")  // PUT /tasks/{id}
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO dto){
        return ResponseEntity.ok(service.updateTask(id, dto));
    }

    @DeleteMapping("/{id}")  // DELETE /tasks/{id}
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}