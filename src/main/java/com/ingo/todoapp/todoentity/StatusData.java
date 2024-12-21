package com.ingo.todoapp.todoentity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "STATUS")
public class StatusData {
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
