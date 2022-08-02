package com.example.activity_tracker.dto.requests;

import com.example.activity_tracker.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private String createdDate;
    private String modifiedDate;
    private String completedDate;
}
