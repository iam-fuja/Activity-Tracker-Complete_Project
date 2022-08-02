package com.example.activity_tracker.dto.requests;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TaskEditDTO {
    private String title;
    private String description;
    private String completedDate;
    private String modifiedDate;

}
