package com.ingo.todoapp.todoentity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

@Data
public class TodoDataDTO {
    private Long id;
    private Date date;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;
    private String activity;
    private String status;
}
