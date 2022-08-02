package com.example.activity_tracker.model;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.enums.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
//@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private String modifiedDate;

    private String completedDate;
}
