package com.bara.todo.service;

import com.bara.todo.dto.TaskDTO;
import com.bara.todo.entity.Task;
import com.bara.todo.exception.NotFoundException;
import com.bara.todo.mapper.TaskMapper;
import com.bara.todo.repository.TaskRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.nio.channels.NotYetBoundException;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository= repository;
    }

    public TaskDTO createTask(TaskDTO dto){
        Task task = TaskMapper.toEntity(dto);
        Task saved = repository.save(task);
        return TaskMapper.toDTO(saved);
    }

    public List<TaskDTO> getAllTasks(){
        return repository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task non trouvée avec id " + id));
        return TaskMapper.toDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO dto){
        Task existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task non trouvée avec id " + id));
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        if(dto.getStatus() != null){
            existing.setStatus(Task.Status.valueOf(dto.getStatus()));
        }
        return TaskMapper.toDTO(repository.save(existing));
    }

    public void deleteTask(Long id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task non trouvée avec id " + id));
        repository.delete(task);
    }
}
