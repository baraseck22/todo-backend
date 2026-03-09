package com.bara.todo.mapper;

import com.bara.todo.dto.TaskDTO;
import com.bara.todo.entity.Task;

public class TaskMapper {
    public static TaskDTO toDTO(Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus().name())
                .build();
    }

    public static Task toEntity(TaskDTO dto){
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        if(dto.getStatus() != null){
            task.setStatus(Task.Status.valueOf(dto.getStatus()));
        }
        return task;
    }
}
