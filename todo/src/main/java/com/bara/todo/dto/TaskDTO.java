package com.bara.todo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class TaskDTO {

    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    private String description;

    private String status;
}
